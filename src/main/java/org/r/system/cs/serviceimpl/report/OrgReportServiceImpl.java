/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.report 
 * @author: Casper   
 * @date: 2018年11月15日 下午1:03:43 
 */
package org.r.system.cs.serviceimpl.report;

import org.r.system.cs.dto.report.OrgReportDTO;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.RequestDetailEntity;
import org.r.system.cs.service.report.OrgReportService;
import org.r.system.cs.service.report.RequestReportService;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Casper
 *
 */
@Component
public class OrgReportServiceImpl implements OrgReportService {

	private final String INCOME = "income";
	private final String EXPEND = "expend";

	@Autowired
	private RequestReportService requestService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.r.system.cs.service.report.OrgReportService#getOrgReportList()
	 */
	@Override
	public List<OrgReportDTO> getOrgReportList(SearchConditionDTO dto) {

		List<OrgReportDTO> list = new ArrayList<>();

		for (int i = 1; i <= UtilTool.getNumDaysByDate(dto.getDate()); i++) {
			OrgReportDTO target = new OrgReportDTO();
			String date = dto.getDate() + "-" + UtilTool.formatDay(String.valueOf(i));
			Map<String, Double> tmp = calculateOneDayFinance(date, dto.getOrgId());
			target.setDate(date);
			target.setIncome(tmp.get(INCOME));
			target.setExpend(tmp.get(EXPEND));

			list.add(target);
		}
//		requestService.getRequestDetails(dto);
		return list;
	}

	private Map<String, Double> calculateOneDayFinance(String date, Integer orgId) {

		Map<String, Double> finance = new HashMap<>();
		finance.put(INCOME, 0.0);
		finance.put(EXPEND, 0.0);

		SearchConditionDTO dto = new SearchConditionDTO();
		dto.setOrgId(orgId);
		dto.setDate(date);

		List<RequestDetailEntity> requests = requestService.getRequestDetails(dto);

		if (requests != null && !requests.isEmpty())
			for (RequestDetailEntity request : requests) {
				Double income = requestService.calculateRequestAmount(request) + finance.get(INCOME);
				finance.put(INCOME, income);
				finance.put(EXPEND, income * request.getSalaryIndex() + finance.get(EXPEND));
			}
		finance.put(EXPEND,(double)Math.round(finance.get(EXPEND)*100)/100);
		return finance;
	}

}
