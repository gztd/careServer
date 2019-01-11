/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.business 
 * @author: Casper   
 * @date: 2018年11月8日 下午2:37:09 
 */
package org.r.system.cs.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.JoinEntity;

/**
 * @author Casper
 *
 */
@Mapper
public interface JoinDao extends BaseDao {

	
	/**
	 * 条件分页查询记录列表
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午4:05:13
	 * @param dto
	 * @return
	 */
	public List<JoinEntity> selectFileList(SearchConditionDTO dto);
	
}
