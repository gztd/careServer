/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.dao 
 * @author: Casper   
 * @date: 2018年10月27日 下午2:31:13 
 */
package org.r.system.cs.dao.baseinfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
import org.r.system.cs.entity.baseinfo.ArrearageEntity;
import org.r.system.cs.entity.baseinfo.PatientEntity;
import org.r.system.cs.entity.baseinfo.TransactionEntity;

/**
 * @author Casper
 *
 */
@Mapper
public interface PatientFileDao {

	/**
	 * 插入病人档案信息到数据库中
	 * 
	 * @author Casper
	 * @date 2018年10月27日 下午2:31:47
	 * @param file
	 * @return 返回影响的行数
	 */
	public int insertPatientFile(PatientEntity file);

	/**
	 * 按条件查询出一页病人
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午3:34:29
	 * @param dto
	 * @return 一页的病人数据
	 */
	public List<PatientEntity> selectPatientFileList(SearchConditionDTO dto);

	/**
	 * 获取病人列表的总长度
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午4:09:06
	 * @param dto
	 * @return
	 */
	public int countPatientListLength(SearchConditionDTO dto);

	/**
	 * 根据病人编号查询病人详细信息
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午4:56:52
	 * @param code
	 *            病人编号
	 * @return 病人详细信息
	 */
	public PatientEntity selectPatientFile(String code);

	/**
	 * 根据病人身份证查询病人详细信息
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午4:57:36
	 * @param idCard
	 *            病人身份证
	 * @return 病人详细信息
	 */
	public PatientEntity selectPatientFileByIdCard(String idCard);

	/**
	 * 差异性更新病人信息
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午5:24:47
	 * @param target
	 * @return 影响的行数
	 */
	public int updatePatientFile(PatientEntity target);

	/**
	 * 新增交易记录
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午7:05:48
	 * @return 影响的行数
	 */
	public int insertTranscationRecord(TransactionEntity target);

	/**
	 * 新增欠费记录
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午7:10:57
	 * @return 影响行数
	 */
	public int insertArrearageReacord(ArrearageEntity target);

	/**
	 * 更新病人余额
	 * 
	 * @author Casper
	 * @date 2018年10月29日 下午7:17:23
	 * @param code
	 *            病人编号
	 * @param balance
	 *            余额
	 * @return 影响行数
	 */
	public int updatePatientBalance(@Param("code") String code, @Param("balance") Double balance);

	/**
	 * 查询交易记录列表
	 * 
	 * @author Casper
	 * @date 2018年10月30日 上午11:57:07
	 * @param dto
	 * @return 交易记录列表
	 */
	public List<TransactionEntity> selectTransactionList(SearchConditionDTO dto);

	/**
	 * 统计交易列表的总长度，即所有查询结果的数量
	 * 
	 * @author Casper
	 * @date 2018年10月30日 下午12:04:45
	 * @param dto
	 * @return 所有查询结果的数量
	 */
	public int countTransactionListLength(SearchConditionDTO dto);
	


}
