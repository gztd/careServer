/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:29:58 
 */
package org.r.system.cs.service.business;

import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.OrderEntity;

/**
 * @author Casper
 *
 */
public interface OrderService extends BaseService {

	/**
	 * 计算服务单的总金额
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午4:30:55
	 * @param orderId
	 * @return
	 */
	public Double calculateServiceAmount(Long orderId);
	
	/**
	 * 获取陪护人员档案资料列表
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午2:09:10
	 * @param dto
	 * @return
	 */
	public ListDTO<OrderEntity> getFileList(SearchConditionDTO dto);
	

}
