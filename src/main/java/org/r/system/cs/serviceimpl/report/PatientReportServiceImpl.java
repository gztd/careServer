/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.report 
 * @author: Casper   
 * @date: 2018年11月15日 上午12:46:37 
 */
package org.r.system.cs.serviceimpl.report;

import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.RequestDetailEntity;
import org.r.system.cs.service.report.PatientReportService;
import org.r.system.cs.service.report.RequestReportService;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Casper
 *
 */
@Component
public class PatientReportServiceImpl implements PatientReportService {

	@Autowired
	private RequestReportService requestService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.report.PatientReportService#getRequestDetailList(org.
	 * r.system.cs.dto.report.SearchConditionDTO)
	 */
	@Override
	public List<RequestDetailEntity> getRequestDetailList(SearchConditionDTO dto) {

		List<RequestDetailEntity> list = buildMonthRequestList(dto.getDate(), dto.getProjectId());
		for (RequestDetailEntity item : list) {
			if (item.getLeaveDate() == null) {
				item.setLeaveDate(UtilTool.getSystemCurrentDateTime());
				item.setStatus("服务中");
			} else {
				item.setStatus("已结束/已出院");
			}
			//item.setDays(UtilTool.getDayDifferenceF(item.getHospitalDate(), item.getLeaveDate()));
			item.setDays(UtilTool.getPatientServiceDay(item.getHospitalDate(), item.getLeaveDate()));
			if (item.getSettleType() == 1)
				item.setAmount(item.getPrice() * item.getDays());
			else
				item.setAmount(item.getPrice());
		}

		return list;
	}

	private List<RequestDetailEntity> buildMonthRequestList(String date, Integer projectId) {
		List<RequestDetailEntity> list = new ArrayList<>();
		SearchConditionDTO dto = new SearchConditionDTO();
		dto.setProjectId(projectId);
		for (int i = 1; i <= UtilTool.getNumDaysByDate(date); i++) {
			String date1 = date + "-" + UtilTool.formatDay(String.valueOf(i));
			dto.setDate(date1);
			List<RequestDetailEntity> tmp = requestService.getRequestDetails(dto);
			if(tmp == null || tmp.isEmpty())continue;
			list.addAll(tmp);
		}
		return list;
	}

}
