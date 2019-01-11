/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.controller 
 * @author: Casper   
 * @date: 2018年10月26日 下午5:44:58 
 */
package org.r.system.cs.controller.baseinfo;

import org.r.system.cs.dto.baseinfo.PatientInfoDTO;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
import org.r.system.cs.dto.baseinfo.TransactionInfoDTO;
import org.r.system.cs.entity.baseinfo.PatientEntity;
import org.r.system.cs.exception.baseinfo.PatientFileException;
import org.r.system.cs.exception.baseinfo.PatientNotFoundException;
import org.r.system.cs.service.baseinfo.ArrearageRecordService;
import org.r.system.cs.service.baseinfo.PatientFileService;
import org.r.system.cs.util.dto.MsgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casper
 *
 */

@RestController
@RequestMapping("/api/baseinfo/patient")
@Slf4j
public class PatientInfoController {

	@Value("${mybatis.mapper-locations}")
	private String path;
	
	
	
	@Autowired
	private PatientFileService fileService;
	
	@Autowired
	private ArrearageRecordService arrearageService;

	@PostMapping("")
	public MsgDTO addPatient(@RequestBody PatientInfoDTO info) {
		MsgDTO msg = null;
		// 判断必须信息项是否为空
		if (info.getName() == null || info.getPhone() == null) {
			msg = new MsgDTO("400", "姓名或联系方式不能为空");
			return msg;
		}
		try {
			String patientCode = fileService.createPatientFile(info);
			msg = new MsgDTO("200", patientCode);
		} catch (PatientFileException e) {
			log.error(e.getMessage(),e);
			msg = new MsgDTO("400", e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public MsgDTO getPatientList(@RequestBody SearchConditionDTO condition) {
		MsgDTO msg = new MsgDTO();
		msg.setCode("200");
		msg.setMsg(fileService.getPatientList(condition));
		return msg;
	}

	@RequestMapping(value = "", method = { RequestMethod.GET })
	public MsgDTO getPatientDetail(@RequestParam(required = false) String code,
			@RequestParam(required = false) String idCard) {
		MsgDTO msg = null;
		// 判断编号和身份证是否同时为空
		if (code == null && idCard == null) {
			msg = new MsgDTO("400", "病人编号和身份证不能同时为空");
			return msg;
		}

		PatientEntity file = null;

		if (code != null) {
			file = fileService.getPatientFile(code);
		} else {
			file = fileService.getPatientFileByidCard(idCard);
		}
		msg = new MsgDTO("200", file);
		return msg;
	}

	@RequestMapping(value = "", method = { RequestMethod.PUT })
	public MsgDTO modifyPatient(@RequestBody PatientInfoDTO info) {
		MsgDTO msg = null;
		// 判断病人编号是否为空
		if (info.getCode() == null) {
			msg = new MsgDTO("400", "病人编号不能为空");
			return msg;
		}
		try {
			if (fileService.modifyPatientFile(info)) {
				msg = new MsgDTO("200", "修改成功");
			} else {
				msg = new MsgDTO("400", "该身份证已有所属的病人");
			}
		} catch (PatientNotFoundException e) {
			log.error(e.getMessage(),e);
			msg = new MsgDTO("400", e.getMsg());
		}
		return msg;
	}

	@RequestMapping(value = "/transaction", method = { RequestMethod.POST })
	public MsgDTO addTransactionRecord(@RequestBody TransactionInfoDTO info) {

		MsgDTO msg = null;
		// 判断必须信息是否为空
		if (info.getCode() == null || info.getMoney() == null || info.getType() == null || info.getMoney() == 0) {
			msg = new MsgDTO("400", "病人编号/金额/类型不能为空且交易金额不能为0");
			return msg;
		}
		if (info.getType() == 2 && (info.getHospitalCode() == null || info.getHospitalName() == null
				|| info.getProjectId() == null || info.getMoney() > 0)) {
			msg = new MsgDTO("400", "当交易类型为结算时，项目编号、服务单据号和医院科室不能为空且交易金额要为负数");
			return msg;
		}
		if (info.getType() == 1 && info.getMoney() < 0) {
			msg = new MsgDTO("400", "当交易类型为充值/续费时，交易金额要为正数");
			return msg;
		}

		try {
			msg = new MsgDTO("200", fileService.createTransactionRecord(info));
		} catch (PatientNotFoundException e) {
			log.error(e.getMessage(),e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (PatientFileException e) {
			log.error(e.getMessage(),e);
			msg = new MsgDTO("400", e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/transaction/list", method = { RequestMethod.POST, RequestMethod.GET })
	public MsgDTO getTransactionRecordList(@RequestBody SearchConditionDTO condition) {
		MsgDTO msg = null;

		// 判断必须信息是否为空
		if (condition.getCode() == null) {
			msg = new MsgDTO("400", "病人编号不能为空");
			return msg;
		}
		msg = new MsgDTO("200", fileService.getTransactionList(condition));

		return msg;
	}

	@RequestMapping(value = "/arrearage/list", method = { RequestMethod.POST, RequestMethod.GET })
	public MsgDTO getArrearageRecordList(@RequestBody SearchConditionDTO condition) {
		MsgDTO msg = null;

		// 判断必须信息是否为空
		if (condition.getCode() == null) {
			msg = new MsgDTO("400", "病人编号不能为空");
			return msg;
		}
		msg = new MsgDTO("200", arrearageService.getArrearageList(condition));
		return msg;
	}

}
