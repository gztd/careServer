/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.business 
 * @author: Casper   
 * @date: 2018年11月14日 上午8:45:52 
 */
package org.r.system.cs.service.authorization;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Casper
 *
 */
public interface ProjectIdSourceService {

	/**
	 * 获取项目编号
	 * @author Casper
	 * @date 2018年11月14日 上午8:47:11
	 * @return
	 */
	public Integer getProjectId(HttpServletRequest req);
	
}
