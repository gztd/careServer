/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.business 
 * @author: Casper   
 * @date: 2018年11月8日 上午10:29:33 
 */
package org.r.system.cs.serviceimpl.business;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.r.system.cs.dto.baseinfo.PatientInfoDTO;
import org.r.system.cs.dto.baseinfo.TransactionInfoDTO;
import org.r.system.cs.dto.business.CareTypeInfoDTO;
import org.r.system.cs.dto.business.CareworkerInfoDTO;
import org.r.system.cs.dto.business.ChangeServiceDTO;
import org.r.system.cs.dto.business.HospitalizedDTO;
import org.r.system.cs.dto.business.LeaveDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.MissionDTO;
import org.r.system.cs.dto.business.OrderInfoDTO;
import org.r.system.cs.dto.business.RequestDetailInfoDTO;
import org.r.system.cs.dto.business.RequestInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.baseinfo.PatientEntity;
import org.r.system.cs.entity.baseinfo.TransactionEntity;
import org.r.system.cs.entity.business.OrderEntity;
import org.r.system.cs.entity.business.RequestDetailEntity;
import org.r.system.cs.entity.business.RequestEntity;
import org.r.system.cs.enums.business.TransactionTypeEnum;
import org.r.system.cs.exception.business.DateParseException;
import org.r.system.cs.exception.business.FileSelectException;
import org.r.system.cs.exception.business.HospitalizedException;
import org.r.system.cs.exception.business.LeaveException;
import org.r.system.cs.service.baseinfo.PatientFileService;
import org.r.system.cs.service.business.CareworkerService;
import org.r.system.cs.service.business.CareTypeService;
import org.r.system.cs.service.business.MissionService;
import org.r.system.cs.service.business.OrderService;
import org.r.system.cs.service.business.PatientService;
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
public class PatientServiceImpl implements PatientService {

	@Autowired
	private OrderService orderService;
	@Autowired
	private RequestService requestService;
	@Autowired
	private PatientFileService patientService;
	@Autowired
	private CareTypeService careTypeService;
	@Autowired
	private CareworkerService careWorkerService;
	@Autowired
	private MissionService missionService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.PatientService#hospitalized(org.r.system.cs.
	 * dto.business.HospitalizedDTO)
	 */
	@Override
	@Transactional
	public Map<String, Object> hospitalized(HospitalizedDTO dto) {

		int level = 1;
		Map<String, Object> result = new HashMap<>();

		try {
			log.info("开始病人信息存储阶段");
			PatientInfoDTO patient = dto.getPatient();
			patientInfoPhase(patient);
			log.info("病人信息存储阶段结束，没有任何异常");

			result.put("patientCode", patient.getCode());
			level++;

			log.info("开始入院单信息存储阶段");
			OrderInfoDTO order = dto.getHospitalizedInfo();
			Long orderId = orderInfoPhase(order);
			log.info("入院单存储阶段结束，没有任何异常");

			result.put("orderCode", order.getCode());
			level++;

			log.info("开始服务单信息存储阶段");
			RequestInfoDTO request = dto.getServiceInfo();
			request.setOrderId(orderId);
			requestInfoPhase(request);
			log.info("服务单存储阶段结束，没有任何异常");

			level++;

			log.info("开始交易信息存储阶段");
			TransactionInfoDTO transaction = dto.getTransactionRecord();
			transactionInfoPhase(transaction, patient.getCode());
			log.info("交易存储阶段结束，没有任何异常");

			level++;

			log.info("开始任务信息存储阶段");
			missionInfoPhase(request);
			log.info("任务信息存储阶段结束，没有任何异常");

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			String msg = null;
			switch (level) {
			case 1:
				msg = "病人信息有误，存储过程中出错：";
				break;
			case 2:
				msg = "入院信息有误，存储过程中出错：";
				break;
			case 3:
				msg = "服务信息有误，存储过程中出错：";
				break;
			case 4:
				msg = "支付信息有误，存储过程中出错：";
				break;
			case 5:
				msg = "派工过程中出错：";
				break;
			default:
				msg = "未知异常";
				break;
			}
			throw new HospitalizedException(msg + " " + e.getMessage());
		}

		return result;
	}

	private void patientInfoPhase(PatientInfoDTO patient) {

		if (patient.getCode() == null) {
			patient.setCode(patientService.createPatientFile(patient));
		} else {
			patientService.modifyPatientFile(patient);
		}

	}

	private Long orderInfoPhase(OrderInfoDTO order) {
		orderService.createFile(order);
		return order.getId();
	}

	private void requestInfoPhase(RequestInfoDTO request) {
		requestService.createFile(request);
	}

	private void transactionInfoPhase(TransactionInfoDTO transaction, String patientCode) {
		if (transaction != null && transaction.getMoney() != 0) {
			transaction.setType(1);
			transaction.setCode(patientCode);
			patientService.createTransactionRecord(transaction);
		}
	}

	private void missionInfoPhase(RequestInfoDTO request) {
		int pro = ((CareTypeInfoDTO) careTypeService.getFile(request.getCareTypeId())).getProperty();
		if (pro == 3) {
			SearchConditionDTO dto = new SearchConditionDTO();
			dto.setOrgId(request.getOrgId());
			dto.setIsOnWork(true);
			dto.setPageSize(null);
			ListDTO<CareworkerInfoDTO> careWorkers = careWorkerService.getCareworkerInfoList(dto);
			MissionDTO mission = new MissionDTO();
			mission.setDateTime(request.getStartTime());
			mission.setRequestCode(request.getCode());
			mission.setCareworkerIds(null);

			for (CareworkerInfoDTO careWorker : careWorkers.getResult()) {
				mission.setCode("MI" + System.currentTimeMillis());
				mission.setCareworkerId(careWorker.getCareworkerId());
				missionService.createFile(mission);
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.PatientService#leave(org.r.system.cs.dto.
	 * business.LeaveDTO)
	 */
	@Override
	@Transactional
	public void leave(LeaveDTO dto) {

		log.info("开始结束服务单阶段");
		OrderEntity order = (OrderEntity) orderService.getFile(dto.getHospitalCode());
		closeOrderPhase(order, dto.getDateTime());
		log.info("结束服务单阶段完成，没有异常");

		log.info("开始结束请求单阶段");
		RequestEntity request = closeRequestPhase(order.getId(), dto.getDateTime());
		log.info("结束请求单阶段完成，没有异常");

		log.info("开始结算阶段");
		TransactionInfoDTO transaction = buildTransactionDTO(order, request);
		settleAccountPhase(transaction, order);
		log.info("结算阶段完成，没有异常");

		log.info("开始退款阶段");
		refundPhase(transaction, dto);
		log.info("退款阶段完成，没有异常");
	}

	private void closeOrderPhase(OrderEntity order, String closeTime) {
		try {
			if (closeTime == null)
				closeTime = UtilTool.getSystemCurrentDateTime();
			order.setLeaveDate(UtilTool.getTimestampByDateTimeString(closeTime));
			if (UtilTool.getDayDifferenceF(order.getHospitalizedDate().toString(), order.getLeaveDate().toString()) < 0)
				throw new LeaveException("出院时间不能早于入院时间");
			orderService.updateFile(order);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			throw new LeaveException("时间格式有误");
		}

	}

	private RequestEntity closeRequestPhase(Long orderId, String closeTime) {
		RequestEntity request = null;
		// 构造搜索条件
		SearchConditionDTO condition = new SearchConditionDTO();
		condition.setOrderId(orderId);
		condition.setIsNewly(true);
		try {
			// 查询最新服务请求单
			request = (RequestEntity) requestService.getRequestFile(condition);
			if (request == null)
				throw new LeaveException("病人不存在或者已经出院");

			request.setEndDateTime(UtilTool.getTimestampByDateTimeString(closeTime));
			// 更新服务请求单结束时间
			requestService.updateFile(request);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			throw new LeaveException("时间格式有误");
		}
		return request;
	}

	private void settleAccountPhase(TransactionInfoDTO transaction, OrderEntity order) {
		transaction.setPayMan(order.getName());
		transaction.setType(2);
		transaction.setMoney(0 - requestService.calculateServiceAmount(order.getId(), order.getLeaveDate()));
		patientService.createTransactionRecord(transaction);
	}

	private void refundPhase(TransactionInfoDTO transaction, LeaveDTO dto) {
		if (dto.getMoney() == null)
			return;
		transaction.setPayMan(dto.getPayMan());
		transaction.setType(3);
		transaction.setMoney(0 - dto.getMoney());
		patientService.createTransactionRecord(transaction);
	}

	private TransactionInfoDTO buildTransactionDTO(OrderEntity order, RequestEntity request) {

		// 构造搜索条件
		SearchConditionDTO condition = new SearchConditionDTO();
		condition.setCode(request.getCode());
		condition.setOrderId(order.getId());
		RequestDetailEntity requestDetail = (RequestDetailEntity) requestService.getRequestDetails(condition);
		TransactionInfoDTO transaction = new TransactionInfoDTO();
		transaction.setHospitalCode(order.getCode());
		transaction.setHospitalName(requestDetail.getOrgName());
		transaction.setDate(order.getLeaveDate().toString());
		transaction.setCode(order.getPatientCode());
		transaction.setProjectId(order.getProjectId());
		return transaction;
	}

	@Override
	public Map<String, Object> getHospitalizedList(SearchConditionDTO dto) {

		ListDTO<OrderEntity> orderList = orderService.getFileList(dto);

		List<OrderEntity> orders = orderList.getResult();

		List<Map<String, Object>> filterResult = new ArrayList<>();

		dto.setIsNewly(true);
		for (OrderEntity order : orders) {
			Map<String, Object> tmp = new HashMap<>();
			// 查询服务单的最后一张请求单信息
			dto.setOrderId(order.getId());
			RequestDetailEntity request = (RequestDetailEntity) requestService.getRequestDetails(dto);
			if (request == null)
				continue;
			tmp.put("order", new OrderInfoDTO(order));
			tmp.put("request", new RequestDetailInfoDTO(request));
			filterResult.add(tmp);
		}
		Map<String, Object> target = new HashMap<>();
		target.put("size", orderList.getSize());
		//target.put("size", filterResult.size());//zack@20190111
		target.put("result", filterResult);
		return target;
	}

	@Override
	@Transactional
	public void changeService(ChangeServiceDTO dto) {

		log.info("开始结束请求单阶段");
		log.info("dto.getLastServiceEndDate()):" + dto.getLastServiceEndDate());
		log.info("dto.getChangeDate():" + dto.getChangeDate());
		closeRequestPhase(dto.getId(),
				dto.getLastServiceEndDate() == null ? dto.getChangeDate() : dto.getLastServiceEndDate());
        //上一次服务结束的时间，可以勾选具体服务结束时间，不勾选时候默认为新服务的变更时间作为当前服务的结束时间@zack
		log.info("结束请求单阶段完成，没有异常");

		log.info("开始服务单信息存储阶段");
		RequestInfoDTO requestInfo = new RequestInfoDTO();
		requestInfo.setOrderId(dto.getId());
		requestInfo.setOrgId(dto.getOrgId());
		requestInfo.setBedNum(dto.getBedNum());
		requestInfo.setCareTypeId(dto.getCareTypeId());
		requestInfo.setClerk(dto.getClerk());
		requestInfo.setStartTime(dto.getChangeDate());
		requestInfoPhase(requestInfo);
		log.info("服务单存储阶段结束，没有任何异常");

		log.info("开始任务信息存储阶段");
		missionInfoPhase(requestInfo);
		log.info("任务信息存储阶段结束，没有任何异常");

	}

	@Override
	public OrderInfoDTO getOrderInfo(String code, Long id) {
		OrderEntity entity = null;

		if (code != null && id == null) {
			entity = (OrderEntity) orderService.getFile(code);
		} else if (id != null) {
			entity = (OrderEntity) orderService.getFile(id);
		}
		if (entity == null)
			throw new FileSelectException("根据编号或者id查询住院服务单出错");

		return new OrderInfoDTO(entity);
	}

	@Override
	public Double getBalance(String code) {
		PatientEntity patient = patientService.getPatientFile(code);
		if (patient == null)
			throw new FileSelectException("病人不存在");

		return patient.getBalance();
	}

	@Override
	public void chargeBalance(TransactionInfoDTO dto) {

		transactionInfoPhase(dto, dto.getCode());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestDetailInfoDTO> getServiceDetailList(Long orderId) {

		// 构造查询条件
		SearchConditionDTO dto = new SearchConditionDTO();
		dto.setOrderId(orderId);

		Object obj = requestService.getRequestDetails(dto);
		List<RequestDetailEntity> result = null;
		if (!(obj instanceof List<?>))
			throw new FileSelectException("查询出错，查询的结果的数据类型不是集合类型");
		result = (List<RequestDetailEntity>) obj;
		List<RequestDetailInfoDTO> list = new ArrayList<>();
		for (RequestDetailEntity request : result) {
			list.add(new RequestDetailInfoDTO(request));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionInfoDTO> getTransactionList(Long orderId) {

		OrderEntity order = (OrderEntity) orderService.getFile(orderId);

		org.r.system.cs.dto.baseinfo.SearchConditionDTO dto = new org.r.system.cs.dto.baseinfo.SearchConditionDTO();
		dto.setPageSize(1000);
		dto.setStartDate(order.getHospitalizedDate().toString());
		dto.setEndDate(
				order.getLeaveDate() == null ? UtilTool.getSystemCurrentDateTime() : order.getLeaveDate().toString());
		dto.setCode(order.getPatientCode());

		List<TransactionEntity> result = (List<TransactionEntity>) patientService.getTransactionList(dto).getResult();
		List<TransactionInfoDTO> list = new ArrayList<>();
		for (TransactionEntity tmp : result) {
			TransactionInfoDTO target = new TransactionInfoDTO();
			target.setCode(tmp.getCode());
			target.setDate(tmp.getDateTime());
			target.setMoney(tmp.getMoney());
			target.setPayMan(tmp.getPayMan());
			target.setHospitalName(TransactionTypeEnum.getSate(tmp.getType()));
			list.add(target);
		}
		return list;
	}

	@Override
	public Double getServiceTotalAmount(Long orderId, String endDate) throws DateParseException {

		Timestamp date = null;
		if (endDate == null)
			date = UtilTool.getSystemCurDateTime();
		else
			try {
				date = UtilTool.getTimestampByDateTimeString(endDate);
			} catch (ParseException e) {
				log.error(e.getMessage(),e);
				throw new DateParseException("日期格式不正确,需要为年月日时分秒");
			}


		return requestService.calculateServiceAmount(orderId, date);
	}
}
