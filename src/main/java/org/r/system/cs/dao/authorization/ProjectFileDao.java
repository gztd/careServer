/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.dao.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 上午9:31:45 
 */
package org.r.system.cs.dao.authorization;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.entity.authorization.ProjectFileEntity;

/**
 * @author Casper
 *
 */
@Mapper
public interface ProjectFileDao {

	/**
	 * 新增一条项目信息记录
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午4:41:48
	 * @return 影响行数
	 */
	public int insertProjectFile(ProjectFileEntity projcet);

	/**
	 * 更新一条项目信息记录
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午4:42:06
	 * @return 影响行数
	 */
	public int updateProjectFile(ProjectFileEntity project);

	/**
	 * 查询一条项目信息记录
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午4:42:23
	 * @return 项目详细的信息
	 */
	public ProjectFileEntity selectProjectFile(Integer projectId);

	/**
	 * 分页按条件查询项目信息列表
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午4:42:35
	 * @return 项目信息列表
	 */
	public List<Map<String, Object>> selectProjectFileList(SearchConditionDTO dto);

	/**
	 * 统计按条件查询项目的结果总数
	 * 
	 * @author Casper
	 * @date 2018年11月5日 下午4:42:52
	 * @return 总数
	 */
	public int countProjectFileListLength(SearchConditionDTO dto);

}
