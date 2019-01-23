/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.report 
 * @author: Casper   
 * @date: 2018年11月11日 上午10:43:18 
 */
package org.r.system.cs.serviceimpl.report;

import org.r.system.cs.dao.report.DutyFileReportDao;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.DutyEntity;
import org.r.system.cs.service.report.DutyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Casper
 *
 */
@Component
public class DutyReportServiceImpl implements DutyReportService {

	@Autowired
	private DutyFileReportDao dutyDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.report.DutyService#getDutyInfoList(org.r.system.cs.
	 * dto.report.SearchConditionDTO)
	 */
	@Override
	public List<DutyEntity> getDutyInfoList(SearchConditionDTO dto) {
		return dutyDao.selectFileList(dto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.report.DutyService#getDutyInfoList(java.lang.Long)
	 */
	@Override
	public List<DutyEntity> getDutyInfoList(Long careworkerId, String date) {
		SearchConditionDTO dto = new SearchConditionDTO();
		dto.setCareworkerId(careworkerId);
		dto.setDate(date);

		return getDutyInfoList(dto);
	}

	@Override
	public Integer calculateDayIndex(Long careworkerId, String date) {
		List<DutyEntity> dutys = getDutyInfoList(careworkerId, date);
		Integer totalDayIndex = 0;
		for (DutyEntity duty : dutys) {
			totalDayIndex += duty.getDayIndex()*(duty.getIsWorked()?1:0);
		}
		return totalDayIndex;
	}

}
