/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.controller.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:06:21 
 */
package org.r.system.cs.controller.business;

import java.util.List;
import java.util.Map;

import org.r.system.cs.dto.baseinfo.TransactionInfoDTO;
import org.r.system.cs.dto.business.ChangeServiceDTO;
import org.r.system.cs.dto.business.HospitalizedDTO;
import org.r.system.cs.dto.business.LeaveDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.exception.business.FileSelectException;
import org.r.system.cs.exception.business.HospitalizedException;
import org.r.system.cs.exception.business.LeaveException;
import org.r.system.cs.service.business.PatientService;
import org.r.system.cs.util.annotation.InjectProjectId;
import org.r.system.cs.util.dto.MsgDTO;
import org.r.system.cs.util.dto.PageDTO;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casper
 *
 */
@RestController
@RequestMapping("/api/busi/patient")
@Slf4j
public class PatientController {

	@Autowired
	private PatientService patientService;

	@InjectProjectId(value = HospitalizedDTO.class, propertyName = "projectId")
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO hospitalized(@RequestBody HospitalizedDTO dto) {
		MsgDTO msg = null;
		if (dto.getPatient() == null || dto.getProjectId() == null) {
			msg = new MsgDTO("400", "病人信息/项目id不能为空");
			return msg;
		}

		if (dto.getPatient().getCode() == "")
			dto.getPatient().setCode(null);

		dto.getHospitalizedInfo().setProjectId(dto.getProjectId());
		try {
			msg = new MsgDTO("200", patientService.hospitalized(dto));

		} catch (HospitalizedException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.DELETE })
	public MsgDTO leave(@RequestBody LeaveDTO dto) {
		MsgDTO msg = null;
		if (dto.getHospitalCode() == null) {
			return new MsgDTO("400", "病人的住院单编号不能为空");
		}
		if (dto.getDateTime() == null)
			dto.setDateTime(UtilTool.getSystemCurrentDateTime());

		try {
			patientService.leave(dto);
			msg = new MsgDTO("200", "出院完成");
		} catch (LeaveException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	@InjectProjectId(value = SearchConditionDTO.class, propertyName = "projectId")
	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getHospitalizedList(@RequestBody SearchConditionDTO condition) {
		MsgDTO msg = null;

		if (condition.getProjectId() == null)
			return new MsgDTO("400", "项目信息不能为空");
		SearchConditionDTO workingCondition = condition;
		if(condition.getOrgId() != null){
			// 处理查询指定陪护人员科室信息
			Integer pageSize = condition.getPageSize();
			Integer curPage = condition.getCurPage();
			condition.setPageSize(5000);
			try {
				Map<String, Object> list = patientService.getHospitalizedList(condition);
				PageDTO page = new PageDTO(1,1,((List)list.get("result")).size());
				page.setResult(list.get("result"));
				msg = new MsgDTO("200", page);
			} catch (FileSelectException e) {
				log.error(e.getMessage(), e);
				msg = new MsgDTO("400", e.getMsg());
			}
		}else {
			try {
				Map<String, Object> list = patientService.getHospitalizedList(condition);
				PageDTO page = new PageDTO(condition.getPageSize(), condition.getCurPage(), (Integer) list.get("size"));
				page.setResult(list.get("result"));
				msg = new MsgDTO("200", page);
			} catch (FileSelectException e) {
				log.error(e.getMessage(), e);
				msg = new MsgDTO("400", e.getMsg());
			}
		}

		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.PUT })
	public MsgDTO changeService(@RequestBody ChangeServiceDTO dto) {
		MsgDTO msg = null;
		if (dto.getOrgId() == null || dto.getId() == null || dto.getCareTypeId() == null
				|| dto.getRequestCode() == null) {
			return new MsgDTO("400", "住院服务单id、服务请求单编号、科室id和陪护类型id不能为空");
		}
		try {
			patientService.changeService(dto);
			msg = new MsgDTO("200", "成功");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	@RequestMapping(value = "/transaction/list", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET })
	public MsgDTO getTransactionList(Long orderId) {
		MsgDTO msg = null;

		if (orderId == null)
			return new MsgDTO("400", "服务单id不能为空");
		try {
			msg = new MsgDTO("200", patientService.getTransactionList(orderId));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getOrder(String code, Long id) {
		MsgDTO msg = null;
		if (code == null && id == null) {
			return new MsgDTO("400", "住院服务单的编号和id不能同时为空");
		}
		try {
			msg = new MsgDTO("200", patientService.getOrderInfo(code, id));
		} catch (FileSelectException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	@RequestMapping(value = "/balance", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getBalance(String code) {
		MsgDTO msg = null;
		if (code == null)
			return new MsgDTO("400", "病人编号不能为空");
		try {
			msg = new MsgDTO("200", patientService.getBalance(code));
		} catch (FileSelectException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/service/amount", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET })
	public MsgDTO getAmount(Long orderId,String endDate) {
		MsgDTO msg = null;
		if (orderId == null)
			return new MsgDTO("400", "服务单id不能为空");

		try {
			msg = new MsgDTO("200", patientService.getServiceTotalAmount(orderId,endDate));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	@RequestMapping(value = "/balance", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO charge(@RequestBody TransactionInfoDTO dto) {
		MsgDTO msg = null;
		if (dto.getCode() == null || dto.getMoney() == null || dto.getMoney() == 0.0 || dto.getPayMan() == null) {
			return new MsgDTO("400", "病人编号、金额和付款人不能为空");
		}

		try {
			patientService.chargeBalance(dto);
			msg = new MsgDTO("200", "充值成功");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	@RequestMapping(value = "/service/list", produces = "application/json;charset=utf-8", method = {
			RequestMethod.GET })
	public MsgDTO getServiceList(Long orderId) {
		MsgDTO msg = null;
		if (orderId == null)
			return new MsgDTO("200", "住院服务单id不能为空");

		try {
			msg = new MsgDTO("200", patientService.getServiceDetailList(orderId));
		} catch (FileSelectException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}
}
