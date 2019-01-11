/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.authorization 
 * @author: Casper   
 * @date: 2018年11月19日 上午10:17:15 
 */
package org.r.system.cs.serviceimpl.authorization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.r.system.cs.service.authorization.ProjectIdSourceService;
import org.springframework.stereotype.Component;

/**
 * @author Casper
 *
 */
@Component
public class ProjectIdSourceServiceImpl implements ProjectIdSourceService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.authorization.ProjectIdSourceService#getProjectId(
	 * javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public Integer getProjectId(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (session == null)
			return null;

		Integer projectId = (Integer) session.getAttribute("projectId");

		return projectId;
	}

}
