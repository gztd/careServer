/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:31:46 
 */
package org.r.system.cs.service.report;

import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.RequestDetailEntity;

import java.util.List;

/**
 * @author Casper
 *
 */
public interface RequestReportService extends BaseService {

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
	public List<RequestDetailEntity> getRequestDetails(SearchConditionDTO dto);

}
