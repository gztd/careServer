/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:34:22 
 */
package org.r.system.cs.serviceimpl.report;

import org.r.system.cs.dao.report.RequestReportDao;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.RequestDetailEntity;
import org.r.system.cs.exception.report.SalaryException;
import org.r.system.cs.service.report.RequestReportService;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Casper
 *
 */
@Component
public class RequestReportServiceImpl implements RequestReportService {

	@Autowired
	private RequestReportDao requestDao;



	@Override
	public List<RequestDetailEntity> getRequestDetails(SearchConditionDTO dto) {

		List<RequestDetailEntity> result = requestDao.selectRequestDetail(dto);
		if (result.isEmpty())
			return null;

		return result;
	}

	@Override
	public Double calculateRequestAmount(Object target) {
		RequestDetailEntity request = null;
		Double total = 0.0;
		if (target instanceof RequestDetailEntity) {
			request = (RequestDetailEntity) target;
		}
		if (request == null) {
			throw new SalaryException("服务请求单不存在，统计一张服务请求单总金额出错");
		}
		String startDate = request.getStartDateTime().toString();
		String endDate = request.getEndDateTime().toString();
		double days = UtilTool.getDayDifference(request.getStartDateTime().toString(),
				request.getEndDateTime().toString());

		if (days < 0)
			// throw new LeaveException("服务时间异常，不可能出现负数时间差");
			return 0.0;
		if (UtilTool.mapDayIndex(startDate) == 2)
			days -= 0.5;
		if (UtilTool.mapDayIndex(endDate) == 1)
			days -= 0.5;
		days = days <= 0.5 ? 0 : days;
		double index = (request.getSettleType() == 2 ? 1.0 : days);
		total += request.getPrice() * index;
		return total;
	}

	@Override
	public Object getFile(Object primaryKey) {
		return null;
	}

	@Override
	public Map<String, Object> getFileList(SearchConditionDTO dto) {
		return null;
	}




}
