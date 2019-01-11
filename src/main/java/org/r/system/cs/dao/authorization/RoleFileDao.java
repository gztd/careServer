/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.dao.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 上午9:31:33 
 */
package org.r.system.cs.dao.authorization;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.entity.authorization.RoleFileEntity;

/**
 * @author Casper
 *
 */
@Mapper
public interface RoleFileDao {

	/**
	 * 添加一条角色记录
	 * 
	 * @author Casper
	 * @date 2018年11月5日 上午11:16:42
	 * @param file
	 * @return 影响行数
	 */
	public int insertRoleFile(RoleFileEntity file);

	/**
	 * 更新一条角色记录
	 * 
	 * @author Casper
	 * @date 2018年11月5日 上午11:16:44
	 * @param file
	 * @return 影响行数
	 */
	public int updateRoleFile(RoleFileEntity file);

	/**
	 * 查询一个角色的详细信息
	 * 
	 * @author Casper
	 * @date 2018年11月5日 上午11:16:47
	 * @param id
	 * @return 角色的详细信息
	 */
	public RoleFileEntity selectRoleFile(Integer id);

	/**
	 * 按条件分页查询角色列表
	 * 
	 * @author Casper
	 * @date 2018年11月5日 上午11:16:50
	 * @param dto
	 * @return 角色列表
	 */
	public List<Map<String, Object>> selectRoleFileList(SearchConditionDTO dto);

	/**
	 * 计算按条件查询的结果的总数
	 * 
	 * @author Casper
	 * @date 2018年11月5日 上午11:16:53
	 * @param dto
	 * @return 结果总数
	 */
	public int countRoleFileListLength(SearchConditionDTO dto);

}
