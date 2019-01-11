/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.aspect.business 
 * @author: Casper   
 * @date: 2018年11月13日 下午11:17:09 
 */
package org.r.system.cs.aspect.authorization;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.r.system.cs.service.authorization.ProjectIdSourceService;
import org.r.system.cs.util.annotation.InjectProjectId;
import org.r.system.cs.util.dto.MsgDTO;
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
public class ProjectIdAspect {

	@Autowired
	private ProjectIdSourceService projectIdService;

	private static final String POINTCUT = "@annotation(org.r.system.cs.util.annotation.InjectProjectId)";

	@Pointcut(POINTCUT)
	public void exec() {

	}

	@Around(POINTCUT)
	public Object injectProjectId(ProceedingJoinPoint joinPoint) {
		ServletRequestAttributes tmp = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = tmp.getRequest();
		Integer projectId = null;
		projectId = getProjectId(request);

		if (projectId == null)
			return new MsgDTO("404", "用户没有登陆/登陆已经过期/项目id不存在");

		InjectProjectId pro = ((MethodSignature) joinPoint.getSignature()).getMethod()
				.getAnnotation(InjectProjectId.class);

		boolean hasException = true;
		String exceptionMsg = null;
		try {
			PropertyDescriptor des = new PropertyDescriptor(pro.propertyName(), pro.value());
			Object targetObject = null;
			for (Object item : joinPoint.getArgs()) {
				if (pro.value().isInstance(item)) {
					targetObject = item;
				}
			}
			Method met = des.getWriteMethod();
			met.invoke(targetObject, projectId);
			hasException = false;
		} catch (IntrospectionException e1) {
			log.error(e1.getMessage(), e1);
			exceptionMsg = e1.getMessage();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			log.error(e.getMessage(), e);
			exceptionMsg = e.getMessage();
		}

		if (hasException) {
			return new MsgDTO("400", exceptionMsg);
		}

		Object target = null;
		try {
			target = joinPoint.proceed();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			target = new MsgDTO("400", e.getMessage());
		}

		return target;
	}

	private Integer getProjectId(HttpServletRequest request) {
		if (projectIdService == null) {
			return null;
		}

		return projectIdService.getProjectId(request);
	}

}
