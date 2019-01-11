/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:34:41 
 */
package org.r.system.cs.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.business.SearchConditionDTO;

/**
 * @author Casper
 *
 */
@Mapper
public interface OrderDao extends BaseDao {

	/**
	 * 用服务单编号查询服务单档案信息
	 * 
	 * @author Casper
	 * @date 2018年11月8日 下午9:14:10
	 * @param orderCode
	 * @return 服务单实体
	 */
	public Object selectFileByCode(String orderCode);
	
	/**
	 * @author Casper
	 * @date 2018年11月11日 下午4:08:44
	 * @param dto
	 * @return
	 */
	public List<Object> selectFileList(SearchConditionDTO dto);
}
