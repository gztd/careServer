/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.serviceimpl 
 * @author: Casper   
 * @date: 2018年10月27日 下午3:19:48 
 */
package org.r.system.cs.serviceimpl.baseinfo;

import java.text.ParseException;

import org.r.system.cs.dao.baseinfo.PatientFileDao;
import org.r.system.cs.dto.baseinfo.PatientInfoDTO;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
import org.r.system.cs.dto.baseinfo.TransactionInfoDTO;
import org.r.system.cs.entity.baseinfo.ArrearageEntity;
import org.r.system.cs.entity.baseinfo.PatientEntity;
import org.r.system.cs.entity.baseinfo.TransactionEntity;
import org.r.system.cs.exception.baseinfo.PatientFileException;
import org.r.system.cs.exception.baseinfo.PatientNotFoundException;
import org.r.system.cs.service.baseinfo.PatientFileService;
import org.r.system.cs.util.dto.PageDTO;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Casper
 *
 */
@Component
public class PatientFilesServiceImpl implements PatientFileService {

	@Autowired
	private PatientFileDao fileDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gztc.cs.baseinfo.patient.service.PatientFileService#createPatientFile(com
	 * .gztc.cs.baseinfo.patient.dto.PatientInfoDTO)
	 */
	@Transactional
	@Override
	public String createPatientFile(PatientInfoDTO info) {
		PatientEntity file = this.buildEntityFromDTO(info);
		try {

			fileDao.insertPatientFile(file);
		} catch (DataIntegrityViolationException e) {
			throw new PatientFileException(e.getCause().getMessage());
		}
		return file.getCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gztc.cs.baseinfo.patient.service.PatientFileService#getPatientList(com.
	 * gztc.cs.baseinfo.patient.util.SearchConditionDTO)
	 */
	@Override
	public PageDTO getPatientList(SearchConditionDTO dto) {
		PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPageOrg(), fileDao.countPatientListLength(dto));
		page.setResult(fileDao.selectPatientFileList(dto));
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gztc.cs.baseinfo.patient.service.PatientFileService#getPatientFile(java.
	 * lang.String)
	 */
	@Override
	public PatientEntity getPatientFile(String code) {
		return fileDao.selectPatientFile(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gztc.cs.baseinfo.patient.service.PatientFileService#
	 * getPatientFileByidCard(java.lang.String)
	 */
	@Override
	public PatientEntity getPatientFileByidCard(String idCard) {
		return fileDao.selectPatientFileByIdCard(idCard);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gztc.cs.baseinfo.patient.service.PatientFileService#modifyPatientFile(com
	 * .gztc.cs.baseinfo.patient.dto.PatientInfoDTO)
	 */
	@Override
	@Transactional
	public boolean modifyPatientFile(PatientInfoDTO info) {
		PatientEntity older = fileDao.selectPatientFile(info.getCode());
		if (older.getCode() == null)
			throw new PatientNotFoundException("病人不存在");
		if (older.getIdCard() != null)
			info.setIdCard(null);
		return fileDao.updatePatientFile(this.buildEntityFromDTO(info)) >= 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gztc.cs.baseinfo.patient.service.PatientFileService#
	 * createTransactionRecord(com.gztc.cs.baseinfo.patient.dto.TransactionInfoDTO)
	 */
	@Override
	@Transactional
	public String createTransactionRecord(TransactionInfoDTO dto) {

		PatientEntity patient = fileDao.selectPatientFile(dto.getCode());
		if (patient == null || patient.getCode() == null)
			throw new PatientNotFoundException("病人不存在");
		TransactionEntity transaction = null;
		try {
			transaction = this.buildEntityFromDTO(dto);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new PatientFileException(e.getMessage());
		}
		transaction.setPatientId(patient.getId());
		if(transaction.getPayMan() == null) {
			transaction.setPayMan(patient.getName());
		}
		if (fileDao.insertTranscationRecord(transaction) == 0)
			throw new PatientFileException("新建交易记录失败，事务回滚");

		Double balance = patient.getBalance() + dto.getMoney();
		if (fileDao.updatePatientBalance(patient.getCode(), balance) == 0)
			throw new PatientFileException("更新余额出错，事务回滚");

		// 如果交易类型时结算
		if (dto.getType() == 2 && balance < 0) {
			Double balance2 = patient.getBalance() < 0 ? dto.getMoney() : balance;
			ArrearageEntity arrearage = null;
			try {
				arrearage = this.buildEntityFromDTO(dto, balance2, patient.getId());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new PatientFileException(e.getMessage());
			}
			if (fileDao.insertArrearageReacord(arrearage) == 0)
				throw new PatientFileException("新建欠费记录失败，事务回滚");
		}

		return transaction.getCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gztc.cs.baseinfo.patient.service.PatientFileService#getTransactionList(
	 * com.gztc.cs.baseinfo.patient.util.SearchConditionDTO)
	 */
	@Override
	public PageDTO getTransactionList(SearchConditionDTO dto) {
		PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPageOrg(), fileDao.countTransactionListLength(dto));
		page.setResult(fileDao.selectTransactionList(dto));
		return page;
	}
	
	/**
	 * 生产病人基础信息档案
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午7:23:36
	 * @param info
	 * @return
	 */
	private  PatientEntity buildEntityFromDTO(PatientInfoDTO info) {
		PatientEntity patient = new PatientEntity();
		patient.setCode(info.getCode() == null ? "PA" + System.currentTimeMillis() : info.getCode());
		patient.setAddress(info.getAddress());
		patient.setIdCard(info.getIdCard());
		patient.setLinkman(info.getLinkman());
		patient.setName(info.getName());
		patient.setPhone(info.getPhone());
		patient.setSex(info.getSex());
		return patient;
	}

	/**
	 * 生产交易记录实体
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午7:23:58
	 * @param info
	 * @return
	 * @throws ParseException 
	 */
	private TransactionEntity buildEntityFromDTO(TransactionInfoDTO info) throws ParseException {
		TransactionEntity transaction = new TransactionEntity();
		transaction.setCode("TR" + System.currentTimeMillis());
		transaction.setDateTime(info.getDate() == null ? UtilTool.getSystemCurDateTime()
				: UtilTool.getTimestampByDateString(info.getDate()));
		transaction.setMoney(info.getMoney());
		transaction.setPayMan(info.getPayMan());
		transaction.setType(info.getType());
		return transaction;
	}

	/**
	 * 生产欠费实体
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午7:24:13
	 * @param info
	 * @param money
	 * @return
	 * @throws ParseException 
	 */
	private ArrearageEntity buildEntityFromDTO(TransactionInfoDTO info, Double money,Long patientId) throws ParseException {
		ArrearageEntity arrearage = new ArrearageEntity();
		arrearage.setDate(info.getDate() == null ? UtilTool.getSystemCurDateTime()
				: UtilTool.getTimestampByDateString(info.getDate()));
		arrearage.setHospitalName(info.getHospitalName());
		arrearage.setProjectId(info.getProjectId());
		arrearage.setRecordCode(info.getHospitalCode());
		arrearage.setMoney(money);
		arrearage.setPatientId(patientId);
		return arrearage;
	}

}
