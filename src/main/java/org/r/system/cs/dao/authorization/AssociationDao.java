/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.dao.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 上午9:32:08 
 */
package org.r.system.cs.dao.authorization;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Casper
 *
 */
@Mapper
public interface AssociationDao {

	/**
	 * 插入关联关系记录
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午6:41:31
	 * @return 影响行数
	 */
	public int insertAssociationFile(@Param("username") String username, @Param("projectId") Integer projectId,
                                     @Param("roleId") List<Integer> roleId, @Param("createDate") Timestamp createDate);

	/**
	 * 删除关联关系记录
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午6:41:57
	 * @return
	 */
	public int deleteAssociationFile(@Param("username") String username, @Param("projectId") Integer projectId);

	/**
	 * 查询用户关联的项目信息
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午7:10:31
	 * @param username
	 * @return 项目列表
	 */
	public List<Map<String, Object>> selectProjectAssosciationFile(@Param("username") String username);

	/**
	 * 查询用户的项目关联的角色信息
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午6:42:22
	 * @return 角色信息列表
	 */
	public List<Map<String, Object>> selectRoleAssociationFile(@Param("username") String username,
                                                               @Param("projectId") Integer projectId);

}
