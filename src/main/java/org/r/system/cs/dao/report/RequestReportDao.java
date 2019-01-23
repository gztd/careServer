/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:35:18 
 */
package org.r.system.cs.dao.report;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.RequestDetailEntity;
import org.r.system.cs.entity.report.RequestEntity;

import java.util.List;

/**
 * @author Casper
 *
 */
@Mapper
public interface RequestReportDao extends BaseDao {

	/**
	 * 查询服务单全部的请求单
	 * 
	 * @author Casper
	 * @date 2018年11月8日 下午9:40:34
	 * @param orderId
	 * @return
	 */
	public List<RequestEntity> selectRequest(Long orderId);

	/**
	 * 查询服务单全部的请求单的详细信息
	 * 
	 * @author Casper
	 * @date 2018年11月8日 下午10:18:58
	 * @param orderId
	 * @return
	 */
	public List<RequestDetailEntity> selectRequestDetail(SearchConditionDTO dto);

}
