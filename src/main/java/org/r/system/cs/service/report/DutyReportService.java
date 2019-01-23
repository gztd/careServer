/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.report 
 * @author: Casper   
 * @date: 2018年11月11日 上午10:00:43 
 */
package org.r.system.cs.service.report;

import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.DutyEntity;

import java.util.List;

/**
 * @author Casper
 *
 */
public interface DutyReportService {

	/**
	 * 根据条件集合查询值勤信息列表
	 * 
	 * @author Casper
	 * @date 2018年11月11日 上午10:42:18
	 * @param dto
	 * @return
	 */
	public List<DutyEntity> getDutyInfoList(SearchConditionDTO dto);

	/**
	 * 根据陪护人员id和日期查询该陪护人员的值勤信息
	 * 
	 * @author Casper
	 * @date 2018年11月11日 上午10:44:05
	 * @param careworkerId
	 * @return
	 */
	public List<DutyEntity> getDutyInfoList(Long careworkerId, String date);

	/**
	 * 计算陪护人员一天的上班系数
	 * 
	 * @author Casper
	 * @date 2018年11月11日 上午10:53:20
	 * @param careworkerId
	 * @param date
	 * @return
	 */
	public Integer calculateDayIndex(Long careworkerId, String date);

}
