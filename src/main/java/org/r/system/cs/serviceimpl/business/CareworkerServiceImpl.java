/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.business 
 * @author: Casper   
 * @date: 2018年11月23日 下午4:32:09 
 */
package org.r.system.cs.serviceimpl.business;

import java.util.List;

import org.r.system.cs.dao.business.CareworkerDao;
import org.r.system.cs.dao.business.JoinDao;
import org.r.system.cs.dto.baseinfo.EmployeeDTO;
import org.r.system.cs.dto.business.CareworkerInfoDTO;
import org.r.system.cs.dto.business.EntryDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.CareworkerEntity;
import org.r.system.cs.entity.business.JoinEntity;
import org.r.system.cs.exception.business.EntryException;
import org.r.system.cs.exception.business.FileSelectException;
import org.r.system.cs.service.baseinfo.EmployeeService;
import org.r.system.cs.service.business.CareworkerService;
import org.r.system.cs.service.business.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casper
 *
 */
@Service
@Slf4j
public class CareworkerServiceImpl implements CareworkerService {

	@Autowired
	private CareworkerDao careworkerDao;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JoinDao joinDao;
	@Autowired
	private JoinService joinService;

	/**
	 * 员工入职
	 */
	@Override
	@Transactional
	public String entry(EntryDTO info) {
		if (info.getEmployee().getCode() != null && isOnjob(info.getEmployee().getCode()))
			throw new EntryException("该员工已经入职在其他科室，请先离职再入职");

		CareworkerEntity entity = new CareworkerEntity();
		EmployeeDTO empdto = info.getEmployee();
		JoinEntity join = new JoinEntity();

		if (empdto.getCode() == null) {
			employeeService.addEmployee(empdto);
		} else {
			employeeService.modifyEmployeeinfo(empdto);
		}

		// 添加陪护人员信息表
		entity.setCode(empdto.getCode());
		entity.setName(empdto.getName());
		entity.setProjectId(info.getProjectId());
		careworkerDao.insertFile(entity);

		// 添加陪护人员与科室的关系
		join.setCareworkerId(entity.getId());
		join.setStartDateTime(info.getStartDateTime());
		join.setOrgId(info.getOrgId());
		joinDao.insertFile(join);

		return entity.getCode();

	}

	/**
	 * 员工离职
	 */
	@Override
	@Transactional
	public void leave(Long careworkerId, String endDateTime) {

		JoinEntity join = joinService.getNewlyJoin(careworkerId);
		join.setEndDateTime(endDateTime);
		joinService.updateFile(join);

	}

	@Override
	public ListDTO<CareworkerEntity> getFileList(SearchConditionDTO dto) {
		return null;
	}

	@Override
	public ListDTO<CareworkerInfoDTO> getCareworkerInfoList(SearchConditionDTO dto) {

		ListDTO<CareworkerInfoDTO> result = new ListDTO<>();
		result.setResult(careworkerDao.selectCareworkerInfo(dto));
		result.setSize(careworkerDao.countFileList(dto));
		return result;
	}

	@Override
	public Object getFile(Object primaryKey) {

		EntryDTO result = new EntryDTO();

		SearchConditionDTO dto = new SearchConditionDTO();
		dto.setPageSize(null);
		dto.setCareworkerId((Long) primaryKey);
		List<CareworkerInfoDTO> careworkers = careworkerDao.selectCareworkerInfo(dto);

		if (careworkers.isEmpty() || careworkers.size() > 1)
			throw new FileSelectException("根据陪护人员id查询陪护人员简要信息出错，不存在该陪护人员或者多于一个陪护人员符合搜索条件");

		result.setOrgId(careworkers.get(0).getOrgId());
		result.setOrgName(careworkers.get(0).getOrgName());
		result.setStartDateTime(careworkers.get(0).getStartDateTime());
		result.setEndDateTime(careworkers.get(0).getEndDateTime());
		result.setEmployee(employeeService.getCodeAndidCard(careworkers.get(0).getCode(), null));

		return result;
	}

	@Override
	public Object createFile(Object dto) {
		return null;
	}

	@Override
	public void updateFile(Object dto) {

	}

	private Boolean isOnjob(String careworkerCode) {
		SearchConditionDTO dto = new SearchConditionDTO();
		dto.setCareworkerCode(careworkerCode);
		dto.setIsOnWork(true);
		ListDTO<CareworkerInfoDTO> target = this.getCareworkerInfoList(dto);

		return !target.getResult().isEmpty();
	}

	@Override
	@Transactional
	public void change(EntryDTO info) {

		log.info("开始离职程序");
		this.leave(info.getCareworkerId(), info.getStartDateTime());
		log.info("离职程序完成，没有异常");

		log.info("开始入职程序");
		JoinEntity joinFile = new JoinEntity();
		joinFile.setCareworkerId(info.getCareworkerId());
		joinFile.setOrgId(info.getOrgId());
		joinFile.setStartDateTime(info.getStartDateTime());
		joinDao.insertFile(joinFile);
		log.info("入职程序完成，没有异常");

	}

}
