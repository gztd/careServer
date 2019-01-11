/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:31:46 
 */
package org.r.system.cs.service.business;

import java.sql.Timestamp;

import org.r.system.cs.dto.business.SearchConditionDTO;

/**
 * @author Casper
 *
 */
public interface RequestService extends BaseService {

	/**
	 * 根据条件查询请求单
	 * 
	 * @author Casper
	 * @date 2018年11月8日 下午9:37:07
	 * @param orderId
	 * @return
	 */
	public Object getRequestFile(SearchConditionDTO dto);

	/**
	 * 计算服务单的总金额
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午4:30:55
	 * @param orderId
	 * @return
	 */
	public Double calculateServiceAmount(Long orderId, Timestamp endDate);
	
	/**
	 * 计算一张服务请求单的总金额
	 * @author Casper
	 * @date 2018年11月8日 下午10:56:47
	 * @param target
	 * @return
	 */
	public Double calculateRequestAmount(Object target);

	/**
	 * 获取服务单对应的全部请求单的服务详细
	 * 
	 * @author Casper
	 * @date 2018年11月8日 下午10:16:53
	 * @param orderId
	 * @return
	 */
	public Object getRequestDetails(SearchConditionDTO dto);

}
