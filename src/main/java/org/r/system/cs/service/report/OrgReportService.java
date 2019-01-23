/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.report 
 * @author: Casper   
 * @date: 2018年11月15日 下午1:01:10 
 */
package org.r.system.cs.service.report;

import org.r.system.cs.dto.report.OrgReportDTO;
import org.r.system.cs.dto.report.SearchConditionDTO;

import java.util.List;

/**
 * @author Casper
 *
 */
public interface OrgReportService {

	/**
	 * 获取科室报表
	 * 
	 * @author Casper
	 * @date 2018年11月15日 下午1:02:28
	 * @return
	 */
	public List<OrgReportDTO> getOrgReportList(SearchConditionDTO dto);

}
