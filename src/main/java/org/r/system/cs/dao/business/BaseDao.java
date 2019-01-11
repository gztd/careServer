/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午3:59:51 
 */
package org.r.system.cs.dao.business;

import org.r.system.cs.dto.business.SearchConditionDTO;


/**
 * @author Casper
 *
 */
public interface BaseDao {

	/**
	 * 插入一条记录
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午4:02:22
	 * @return
	 */
	public int insertFile(Object entity);

	/**
	 * 更新一条记录
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午4:04:54
	 * @param entity
	 * @return
	 */
	public int updateFile(Object entity);

	/**
	 * 查询一条记录
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午4:05:05
	 * @param primaryKey
	 * @return
	 */
	public Object selectFile(Object primaryKey);

	/**
	 * 不分页统计条件查询记录列表的长度
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午4:05:36
	 * @param dto
	 * @return
	 */
	public int countFileList(SearchConditionDTO dto);

}
