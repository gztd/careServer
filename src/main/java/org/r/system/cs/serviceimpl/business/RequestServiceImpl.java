/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:34:22 
 */
package org.r.system.cs.serviceimpl.business;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import org.r.system.cs.dao.business.RequestDao;
import org.r.system.cs.dto.business.RequestInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.RequestDetailEntity;
import org.r.system.cs.entity.business.RequestEntity;
import org.r.system.cs.exception.business.FileInsertException;
import org.r.system.cs.exception.business.FileSelectException;
import org.r.system.cs.exception.business.LeaveException;
import org.r.system.cs.service.business.RequestService;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casper
 *
 */
@Component
@Slf4j
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestDao requestDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.r.system.cs.service.business.BaseService#getFile(java.lang.Object)
	 */
	@Override
	public Object getFile(Object primaryKey) {

		return requestDao.selectFile(primaryKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.BaseService#createFile(java.lang.Object)
	 */
	@Override
	@Transactional
	public Object createFile(Object dto) {
		RequestEntity request = null;
		try {
			if (dto instanceof RequestInfoDTO)
				request = ((RequestInfoDTO) dto).build();
			else if (dto instanceof RequestEntity)
				request = (RequestEntity) dto;
			request.setCode("RE" + System.currentTimeMillis());
			requestDao.insertFile(request);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			throw new FileInsertException("时间格式有误");
		}
		return request.getCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.BaseService#updateFile(java.lang.Object)
	 */
	@Override
	public void updateFile(Object dto) {
		requestDao.updateFile(dto);
	}

	@Override
	public Object getRequestFile(SearchConditionDTO dto) {

		if (dto.getIsNewly()) {
			return requestDao.selectNewlyRequest(dto.getOrderId());
		} else {
			return requestDao.selectRequest(dto.getOrderId());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Double calculateServiceAmount(Long orderId, Timestamp endDate) {

		// 构造搜索条件
		SearchConditionDTO condition = new SearchConditionDTO();
		condition.setCode(null);
		condition.setOrderId(orderId);
		// 获取服务单的所有请求单详细信息
		List<RequestDetailEntity> requests = (List<RequestDetailEntity>) getRequestDetails(condition);
		Double totalAmount = 0.0;
		// 循环统计每张请求单的总金额
		for (RequestDetailEntity request : requests) {
			if (request.getEndDateTime() == null)
				request.setEndDateTime(endDate);
			totalAmount += calculateRequestAmount(request);
		}

		return totalAmount;
	}

	@Override
	public Object getRequestDetails(SearchConditionDTO dto) {

		List<RequestDetailEntity> result = requestDao.selectRequestDetail(dto);
		if (result.isEmpty())
			return null;
		for(RequestDetailEntity target : result) {
			if(target.getEndDateTime() == null)continue;
			calculateRequestAmount(target);
		}
		if (dto.getCode() != null || (dto.getIsNewly() != null && dto.getIsNewly())) {
			if (result.size() > 1)
				throw new FileSelectException("查询最新/目标服务详细信息出错，服务请求单编号已给出：" + dto.getCode() + ",查询结果集数量期望为1，实际大于1");
			return result.get(0);
		}
		
		

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
			throw new LeaveException("服务请求单不存在，统计一张服务请求单总金额出错");
		}

		Double days = UtilTool.getPatientServiceDay(request.getStartDateTime().toString()
				,request.getEndDateTime().toString());
		request.setDays(days);
		double index = (request.getSettleType() == 2 ? 1.0 : days);
		total += request.getPrice() * index;
		request.setDays(days);
		request.setAmount(total);
		return total;
		/*

		String startDate = request.getStartDateTime().toString().substring(0,19);
		String endDate = request.getEndDateTime().toString().substring(0,19);
		double MIN_FREE_TIME = 1.0/24;// TO-DO:1小时以内结束服务，不计算服务天数，后续可以改
        String formatStr = "yyyy-MM-dd HH:mm:ss";
        double delta = UtilTool.getDayDiffernece(startDate,endDate,formatStr);
		if (delta <= MIN_FREE_TIME) {
			request.setDays(0.0);
			request.setAmount(0.0);
			// throw new LeaveException("服务时间异常，不可能出现负数时间差");
			return 0.0;
		}
        double days = UtilTool.getDayDifference(startDate,endDate);

		if (UtilTool.mapDayIndex(startDate) == 2)
			days -= 0.5;
		if (UtilTool.mapDayIndex(endDate) == 1)
			days -= 0.5;
		//days = days <= 0.5 ? 0 : days;
		days = days <= 0.5 ? 0.5 : days;//被分配服务，最少算半天@zack
		double index = (request.getSettleType() == 2 ? 1.0 : days);
		total += request.getPrice() * index;
		request.setDays(days);
		request.setAmount(total);
		return total;
		*/
	}

}
