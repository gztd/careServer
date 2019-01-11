/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.aspect.authorization 
 * @author: Casper   
 * @date: 2018年11月19日 下午7:42:15 
 */
package org.r.system.cs.aspect.authorization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.r.system.cs.entity.authorization.LogEntity;
import org.r.system.cs.enums.authorization.OperationNameEnum;
import org.r.system.cs.service.authorization.OperationLogService;
import org.r.system.cs.util.dto.MsgDTO;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casper
 *
 */
@Configuration
@Aspect
@Slf4j
public class OperationAspect {

	private static final String POINTCUT = "execution(public * org.r.system.cs.controller..*.*(..))";
	private String[] allowUrl = { "/api/aut/token", "/api/aut/association/project" };

	@Autowired
	private OperationLogService operationLogService;

	@Pointcut(POINTCUT)
	public void excu() {

	}

	@Around(POINTCUT)
	public Object operationLog(ProceedingJoinPoint joinPoint) {

		ServletRequestAttributes tmp = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = tmp.getRequest();
		boolean isLogin = isLoginURI(request.getRequestURI());
		HttpSession session = request.getSession();
		String username = null;
		if(isLogin) {
			username = request.getParameter("username");
		}else if(!session.isNew()) {
			username = (String) session.getAttribute("username");
		}else {
			return new MsgDTO("404", "用户未登陆/登陆已超时");
		}

		Long startTime = System.currentTimeMillis();

		Object target = null;

		try {
			target = joinPoint.proceed();
		} catch (Throwable e1) {
			log.error(e1.getMessage(), e1);
			target = new MsgDTO("400", e1.getMessage());
		}

		try {
			String ipAddress = request.getRemoteAddr();
			String uri = request.getRequestURI();
			String method = request.getMethod();
			Double timeConsuming = (System.currentTimeMillis() * 1.0 - startTime) / 1000;
			LogEntity logFile = new LogEntity();
			logFile.setDateTime(UtilTool.getSystemCurDateTime());
			logFile.setOperator(username);
			logFile.setInterfaces(uri);
			logFile.setIpAddress(ipAddress);
			logFile.setTimeConsuming(timeConsuming);
			logFile.setOperationName(OperationNameEnum.getSate(uri, method));
			operationLogService.createFile(logFile);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return target;
	}

	private boolean isLoginURI(String url) {
		for (String target : allowUrl) {
			if (url.indexOf(target) != -1)
				return true;
		}
		return false;
	}

}
