/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.service 
 * @author: Casper   
 * @date: 2018年10月30日 下午8:10:34 
 */
package org.r.system.cs.service.baseinfo;

import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
import org.r.system.cs.util.dto.PageDTO;

/**
 * @author Casper
 *
 */
public interface ArrearageRecordService {
	/**
	 * 获取欠费记录列表
	 * 
	 * @author Casper
	 * @date 2018年10月30日 下午3:39:49
	 * @param dto
	 * @return 一页的交易记录列表
	 */
	public PageDTO getArrearageList(SearchConditionDTO dto);

}
