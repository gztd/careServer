/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.service 
 * @author: Casper   
 * @date: 2018年10月27日 下午2:12:23 
 */
package org.r.system.cs.service.baseinfo;

import org.r.system.cs.dto.baseinfo.PatientInfoDTO;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
import org.r.system.cs.dto.baseinfo.TransactionInfoDTO;
import org.r.system.cs.entity.baseinfo.PatientEntity;
import org.r.system.cs.util.dto.PageDTO;

/**
 * @author Casper
 *
 */
public interface PatientFileService {

	/**
	 * 新建病人档案
	 * 
	 * @author Casper
	 * @date 2018年10月27日 下午2:22:49
	 * @param info
	 * @return 病人编号
	 */
	public String createPatientFile(PatientInfoDTO info);

	/**
	 * 查询病人列表
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午3:49:31
	 * @param dto
	 * @return 病人列表
	 */
	public PageDTO getPatientList(SearchConditionDTO dto);

	/**
	 * 根据病人编号查询病人详细信息
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午4:56:52
	 * @param code
	 *            病人编号
	 * @return 病人详细信息
	 */
	public PatientEntity getPatientFile(String code);

	/**
	 * 根据病人身份证查询病人详细信息
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午4:57:36
	 * @param idCard
	 *            病人身份证
	 * @return 病人详细信息
	 */
	public PatientEntity getPatientFileByidCard(String idCard);

	/**
	 * 修改病人基本信息
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午5:33:35
	 * @param info
	 * @return 成功-true,失败-false
	 */
	public boolean modifyPatientFile(PatientInfoDTO info);

	/**
	 * 新增交易记录
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午6:59:25
	 * @param dto
	 * @return 影响行数
	 */
	public String createTransactionRecord(TransactionInfoDTO dto);

	/**
	 * 获取交易记录列表
	 * 
	 * @author Casper
	 * @date 2018年10月30日 上午11:55:40
	 * @param dto
	 * @return 一页的交易记录列表
	 */
	public PageDTO getTransactionList(SearchConditionDTO dto);



}
