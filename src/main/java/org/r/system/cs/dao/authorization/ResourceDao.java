/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.authorization 
 * @author: Casper   
 * @date: 2018年11月5日 下午11:52:56 
 */
package org.r.system.cs.dao.authorization;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.r.system.cs.entity.authorization.ResourceEntity;

/**
 * @author Casper
 *
 */
@Mapper
public interface ResourceDao {

	/**
	 * 获取全部功能点资源信息，不包括模块
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午11:53:33
	 * @return 功能点信息列表
	 */
	public List<Map<String, Object>> selectResouceList();

	/**
	 * 获取全部资源
	 * 
	 * @author Casper
	 * @date 2018年11月22日 下午1:21:14
	 * @return
	 */
	public List<ResourceEntity> selectResourcesList();
	
	/**
	 * @author Casper
	 * @date 2018年11月22日 下午3:15:08
	 * @param target
	 * @return
	 */
	public int updateFile(Object target);

	/**
	 * 查询用户在项目中模块
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午3:19:39
	 * @param username
	 * @param projectId
	 * @return
	 */
	public List<Map<String, Object>> selectModule(@Param("username") String username,
                                                  @Param("projectId") Integer projectId);

	/**
	 * 查询用户在模块中的功能
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午3:19:47
	 * @param username
	 * @param projectId
	 * @param resId
	 * @return
	 */
	public List<Map<String, Object>> selectFunction(@Param("username") String username,
                                                    @Param("projectId") Integer projectId, @Param("resId") Integer resId);

}
