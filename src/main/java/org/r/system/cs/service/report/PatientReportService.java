/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.report 
 * @author: Casper   
 * @date: 2018年11月15日 上午12:45:05 
 */
package org.r.system.cs.service.report;

import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.RequestDetailEntity;

import java.util.List;

/**
 * @author Casper
 *
 */
public interface PatientReportService {

	/**
	 * 根据条件查询病人住院报表
	 * 
	 * @author Casper
	 * @date 2018年11月15日 上午12:45:59
	 * @param dto
	 * @return
	 */
	public List<RequestDetailEntity> getRequestDetailList(SearchConditionDTO dto);

}
