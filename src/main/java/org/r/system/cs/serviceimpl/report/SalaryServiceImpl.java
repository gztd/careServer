/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午3:06:58 
 */
package org.r.system.cs.serviceimpl.report;

import lombok.extern.slf4j.Slf4j;
import org.r.system.cs.dto.report.CareworkerDetialDTO;
import org.r.system.cs.dto.report.SalaryCellDTO;
import org.r.system.cs.dto.report.SalaryUnitDTO;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.MissionEntity;
import org.r.system.cs.entity.report.RequestDetailEntity;
import org.r.system.cs.service.report.*;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Casper
 *
 */
@Component
@Slf4j
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private CareworkerReportService careworkerService;

	@Autowired
	private RequestReportService requestService;

	@Autowired
	private MissionReportService missionSerivce;

	@Autowired
	private DutyReportService dutyService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.report.SalaryService#getCareWorkerSalary(java.lang.
	 * Integer, java.lang.String)
	 */
	@Override
	public List<SalaryUnitDTO> getCareWorkerSalary(Integer projectId, String date) {

		log.info("开始构建陪护人员科室数据关系集合");
		Map<Integer, String> orgInfo = new HashMap<>();
		Map<Integer, Map<Long, Object>> careworkersOrg = buildCarewokerOrgCollection(projectId, orgInfo);
		Map<Long, Object> careworkers = buildCarewokerCollection(careworkersOrg);
		log.info("构建完成");

		log.info("开始统计陪护人员工资");
		for (int i = 1; i <= UtilTool.getNumDaysByDate(date); i++) {
			oneDaySalaryPhase(date + "-" + UtilTool.formatDay(String.valueOf(i)), careworkers, projectId);
		}
		log.info("统计完成");

		log.info("开始构建陪护人员工资报表");
		List<SalaryUnitDTO> result = new ArrayList<>();
		for (Entry<Integer, Map<Long, Object>> item : careworkersOrg.entrySet()) {
			SalaryUnitDTO unit = new SalaryUnitDTO();
			unit.setOrgName(orgInfo.get(item.getKey()));
			List<SalaryCellDTO> salarys = new ArrayList<>();
			for (Entry<Long, Object> tmp : item.getValue().entrySet()) {
				salarys.add((SalaryCellDTO) tmp.getValue());
			}
			unit.setCareworkers(salarys);
			result.add(unit);
		}
		log.info("构建陪护人员工资报表完成");
		return result;
	}

	private Map<Integer, Map<Long, Object>> buildCarewokerOrgCollection(Integer projectId,
			Map<Integer, String> orgInfo) {
		List<CareworkerDetialDTO> careworkers = careworkerService.getCareworkerInOrg(projectId, null);
		Map<Integer, Map<Long, Object>> result = new HashMap<>();

		// 建立数据结构，关联陪护人员和科室、陪护人员和其工资信息实体
		for (CareworkerDetialDTO careworker : careworkers) {
			SalaryCellDTO cell = new SalaryCellDTO();
			cell.setJobName("护工");
			cell.setName(careworker.getName());

			// 存放陪护人员的工资信息
			Map<Long, Object> salary = result.get(careworker.getOrgId());
			if (salary == null) {
				salary = new HashMap<>();
				result.put(careworker.getOrgId(), salary);
			}
			salary.put(careworker.getId(), cell);
			orgInfo.put(careworker.getOrgId(), careworker.getOrgName());
		}

		return result;
	}

	private Map<Long, Object> buildCarewokerCollection(Map<Integer, Map<Long, Object>> careworkersOrg) {

		Map<Long, Object> careworkerSalary = new HashMap<>();
		for (Entry<Integer, Map<Long, Object>> item : careworkersOrg.entrySet()) {
			for (Entry<Long, Object> tmp : item.getValue().entrySet())
				careworkerSalary.put(tmp.getKey(), tmp.getValue());
		}
		return careworkerSalary;
	}

	private void oneDaySalaryPhase(String date, Map<Long, Object> careworkers, Integer projectId) {

		SearchConditionDTO dto = new SearchConditionDTO();
		dto.setDate(date);
		dto.setProjectId(projectId);

		List<RequestDetailEntity> requests = requestService.getRequestDetails(dto);

		if (requests == null)
			return;

		for (RequestDetailEntity request : requests) {
			// 统计一张服务请求单的支出金额
			Double amount = requestService.calculateRequestAmount(request) * request.getSalaryIndex();
			amount = (double) Math.round(100*amount)/100;
			// 查询服务请求单下挂的任务单信息，从而获取有那些陪护人员在提供服务
			List<MissionEntity> mission = missionSerivce.getMissionFileList(request.getCode());
			// 统计提供服务的陪护人员的值班系数的比例分数，用于计算分得的工资
			Map<Long, Double> dayIndexConllection = buildDayIndexCollection(extractCareworker(mission), date);
			// 更新提供服务的陪护人员的工资信息
			for (Entry<Long, Double> careWorkDayRatio : dayIndexConllection.entrySet()) {
				SalaryCellDTO cell = (SalaryCellDTO) careworkers.get(careWorkDayRatio.getKey());
				double tSalary = cell.getSalary() + amount * careWorkDayRatio.getValue();
				cell.setSalary((double) Math.round(100*tSalary)/100);
				cell.setCountDay(cell.getCountDay() + (careWorkDayRatio.getValue() == 0 ? 0 : 1));
			}
		}

	}

	/**
	 * 构建陪护人员的值班系数比例分数
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午12:32:27
	 * @param careworkerIds
	 * @param date
	 * @return
	 */
	private Map<Long, Double> buildDayIndexCollection(List<Long> careworkerIds, String date) {

		Integer totalDayIndex = 0;
		Integer curDayIndex = 0;
		Map<Long, Double> result = new HashMap<>();

		for (Long careworkerId : careworkerIds) {
			curDayIndex = dutyService.calculateDayIndex(careworkerId, date);
			result.put(careworkerId, curDayIndex * 1.0);
			totalDayIndex += curDayIndex;
		}
		if (totalDayIndex != 0)
			for (Long careworkerId : careworkerIds) {
				result.put(careworkerId, result.get(careworkerId) / totalDayIndex);
			}

		return result;
	}

	/**
	 * 从任务单数组中提取陪护人员id组成陪护人员id数组
	 * 
	 * @author Casper
	 * @date 2018年11月11日 上午11:05:47
	 * @param missions
	 * @return
	 */
	private List<Long> extractCareworker(List<MissionEntity> missions) {
		List<Long> result = new ArrayList<>();
		for (MissionEntity mission : missions) {
			result.add(mission.getCareworkerId());
		}
		return result;
	}

}
