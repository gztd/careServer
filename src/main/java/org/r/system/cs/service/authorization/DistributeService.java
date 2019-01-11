/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.service.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午7:59:57 
 */
package org.r.system.cs.service.authorization;

import java.util.List;
import java.util.Map;

/**
 * @author Casper
 *
 */
public interface DistributeService {

	/**
	 * 建立一个用户在一个项目中的多个角色关系
	 * 
	 * @author Casper
	 * @date 2018年11月1日 上午9:05:04
	 * @param username
	 *            用户名
	 * @param project
	 *            项目编号
	 * @param role
	 *            角色编号列表
	 * @return 创建成功true，创建失败false
	 */
	public boolean createAssociation(String username, Integer project, List<Integer> role);

	/**
	 * 1、当project为null时，查询用户所拥有的项目信息 2、当project不为null时，根据用户名和项目id获取用户在该项目的角色信息
	 * 
	 * @author Casper
	 * @date 2018年11月1日 上午9:07:10
	 * @param username
	 * @param project
	 * @return 信息列表[{id:xxxx,name:xxxx}]
	 */
	public List<Map<String, Object>> getAssociation(String username, Integer project);

	/**
	 * 更新联系，先根据用户名和项目ID删除旧的联系，再重新建立新的联系
	 * 
	 * @author Casper
	 * @date 2018年11月1日 上午9:19:59
	 * @param username
	 * @param porject
	 * @param role
	 * @return 创建成功true，创建失败false
	 */
	public boolean modigyAssociation(String username, Integer project, List<Integer> role);

}
