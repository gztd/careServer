/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.controller.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午8:09:57 
 */
package org.r.system.cs.controller.authorization;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.r.system.cs.entity.authorization.SysInfo;
import org.r.system.cs.entity.authorization.UserFileEntity;
import org.r.system.cs.service.authorization.AuthorizationService;
import org.r.system.cs.service.authorization.DistributeService;
import org.r.system.cs.service.authorization.UserService;
import org.r.system.cs.util.dto.MsgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casper
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/aut/token")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private DistributeService distributeService;

	@Autowired
	private AuthorizationService autService;

	@RequestMapping(value = "", method = { RequestMethod.POST })
	public MsgDTO login(String username, String password, Integer projectId, HttpServletRequest req) {
		MsgDTO msg = null;
		HttpSession session = req.getSession();

		if (!SysInfo.isStillAviable()) {
			msg = new MsgDTO("404", "已达最大站点数");
			return msg;
		}

		// 判断用户名密码是否为空
		if (username == null || password == null) {
			msg = new MsgDTO("404", "用户名和密码不能为空");
			return msg;
		}

		HttpSession session2 = (HttpSession) SysInfo.getValue(username);

		if (SysInfo.contain(username) && !session2.getId().equals(session.getId())) {
			SysInfo.removeSession(username);
			session2.invalidate();
		}

		UserFileEntity user = (UserFileEntity) userService.getFile(username);
		// 判断用户是否存在
		if (user == null) {
			msg = new MsgDTO("404", "用户不存在");
			return msg;
		}
		// 判断密码是否正确
		if (!autService.verifyPassword(password, user.getPassword())) {
			msg = new MsgDTO("404", "密码错误");
			return msg;
		}

		if (!user.getUsername().equals("admin")) {
			// 判断用户有没有项目权限
			boolean isill = true;
			for (Map<String, Object> target : distributeService.getAssociation(username, null)) {
				if (target.containsValue(projectId)) {
					isill = false;
					break;
				}
			}
			if (isill) {
				msg = new MsgDTO("404", "用户没有该项目的权限");
				return msg;
			}
		}

		msg = new MsgDTO("200", autService.createToken(username, String.valueOf(projectId)));

		session.setAttribute("username", username);
		session.setAttribute("projectId", projectId);
		session.setAttribute("Authorization", (String)msg.getMsg());

		SysInfo.addSession(username, session);

		return msg;
	}

	@RequestMapping(value = "", method = { RequestMethod.PUT })
	public MsgDTO logout(String username, HttpServletRequest req) {
		MsgDTO msg = null;
		HttpSession session = req.getSession();
		if (session == null) {
			msg = new MsgDTO("404", "该用户已经登出");
			return msg;
		}

		session.invalidate();
		msg = new MsgDTO("200", "");
		return msg;
	}

	@RequestMapping("/test")
	public int getCount() {
		
		String tmp = null;
		try {
			tmp.length();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
		}
		
		return SysInfo.getPoolSize();
	}

}
