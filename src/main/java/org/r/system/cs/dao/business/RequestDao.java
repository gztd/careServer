/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:35:18 
 */
package org.r.system.cs.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.RequestDetailEntity;
import org.r.system.cs.entity.business.RequestEntity;

/**
 * @author Casper
 *
 */
@Mapper
public interface RequestDao extends BaseDao {

	/**
	 * 查询服务单对应的最新请求单
	 * 
	 * @author Casper
	 * @date 2018年11月8日 下午9:40:09
	 * @param orderId
	 * @return
	 */
	public RequestEntity selectNewlyRequest(Long orderId);

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
