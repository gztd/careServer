/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.dao.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 下午4:10:11 
 */
package org.r.system.cs.dao.authorization;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Casper
 *
 */
@Mapper
public interface OwnFileDao {

	/**
	 * 添加角色资源关心记录
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午2:11:35
	 * @param roleId
	 * @param auths
	 * @return 影响行数
	 */
	public int insertOwnFile(@Param("roleId") Integer roleId, @Param("auths") List<Integer> auths);

	/**
	 * 删除角色资源记录，只有角色id或者只有资源id时，删除匹配id的所有记录，二者不能同时为空
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午2:13:22
	 * @param roleId
	 * @param authId
	 * @return 影响行数
	 */
	public int deleteOwnFile(@Param("roleId") Integer roleId, @Param("authId") Integer authId);

	/**
	 * 查询角色的所有可用资源权限
	 * @author Casper
	 * @date 2018年11月5日 下午2:18:19
	 * @param roleId
	 * @return 可用的资料权限列表，{id:xxx,name:xxx}
	 */
	public List<Map<String, Object>> selectOwnFile(Integer roleId);
	
}
