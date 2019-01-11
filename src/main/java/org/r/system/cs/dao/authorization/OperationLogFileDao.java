/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.authorization 
 * @author: Casper   
 * @date: 2018年11月19日 下午10:58:22 
 */
package org.r.system.cs.dao.authorization;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.entity.authorization.LogEntity;

/**
 * @author Casper
 *
 */
@Mapper
public interface OperationLogFileDao {

	/**
	 * 插入一条操作记录
	 * 
	 * @author Casper
	 * @date 2018年11月19日 下午11:51:27
	 * @param file
	 * @return
	 */
	public int insertFile(Object file);

	/**
	 * 获取列表
	 * 
	 * @author Casper
	 * @date 2018年11月22日 下午7:15:25
	 * @return
	 */
	public List<LogEntity> selectFileList(SearchConditionDTO dto);

	/**
	 * 统计列表长度
	 * 
	 * @author Casper
	 * @date 2018年11月22日 下午7:42:37
	 * @param dto
	 * @return
	 */
	public int countList(SearchConditionDTO dto);

}
