/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.authorization 
 * @author: Casper   
 * @date: 2018年11月5日 下午11:50:09 
 */
package org.r.system.cs.service.authorization;

import java.util.List;
import java.util.Map;

import org.r.system.cs.entity.authorization.ResourceEntity;

/**
 * @author Casper
 *
 */
public interface ResourceService {

	/**
	 * 获取全部功能，不包括父资源
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午11:51:27
	 * @return 功能信息列表
	 */
	public List<Map<String, Object>> getResourceList();

	/**
	 * 获取全部资源
	 * 
	 * @author Casper
	 * @date 2018年11月22日 下午1:20:02
	 * @return
	 */
	public List<ResourceEntity> getResourcesList();

	/**
	 * 更新资源信息
	 * 
	 * @author Casper
	 * @date 2018年11月22日 下午3:13:12
	 * @param info
	 */
	public void modifyResource(ResourceEntity info);

	public Object getModule(String username, Integer projectId);

}
