/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.business 
 * @author: Casper   
 * @date: 2018年11月8日 上午10:21:30 
 */
package org.r.system.cs.service.business;

import java.util.List;
import java.util.Map;

import org.r.system.cs.dto.baseinfo.TransactionInfoDTO;
import org.r.system.cs.dto.business.ChangeServiceDTO;
import org.r.system.cs.dto.business.HospitalizedDTO;
import org.r.system.cs.dto.business.LeaveDTO;
import org.r.system.cs.dto.business.OrderInfoDTO;
import org.r.system.cs.dto.business.RequestDetailInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.exception.business.DateParseException;

/**
 * @author Casper
 *
 */
public interface PatientService {

	/**
	 * 执行病人入院流程
	 * 
	 * @author Casper
	 * @date 2018年11月8日 上午10:27:07
	 * @param dto
	 * @return 病人编号和住院单编号，{patientCode:xxxxx,orderCode:xxxx}
	 */
	public Map<String, Object> hospitalized(HospitalizedDTO dto);

	/**
	 * 执行病人出院流程
	 * 
	 * @author Casper
	 * @date 2018年11月8日 下午8:37:44
	 * @param dto
	 */
	public void leave(LeaveDTO dto);

	/**
	 * 根据搜索条件分页查询住院信息列表
	 * 
	 * @author Casper
	 * @date 2018年11月9日 上午9:23:17
	 * @param dto
	 */
	public Map<String, Object> getHospitalizedList(SearchConditionDTO dto);

	/**
	 * 变更服务类型
	 * 
	 * @author Casper
	 * @date 2018年11月9日 下午5:20:35
	 * @param dto
	 */
	public void changeService(ChangeServiceDTO dto);

	/**
	 * 根据id或者编号获取服务单信息，二者都有时，以id为准
	 * 
	 * @author Casper
	 * @date 2018年11月9日 下午5:21:49
	 * @param code
	 * @param id
	 * @return
	 */
	public OrderInfoDTO getOrderInfo(String code, Long id);

	/**
	 * 获取病人余额
	 * 
	 * @author Casper
	 * @date 2018年11月9日 下午5:36:29
	 * @param code
	 * @return
	 */
	public Double getBalance(String code);

	/**
	 * 充值病人余额
	 * 
	 * @author Casper
	 * @date 2018年11月9日 下午9:51:31
	 * @param dto
	 */
	public void chargeBalance(TransactionInfoDTO dto);

	/**
	 * 查询服务请求详细信息列表
	 * 
	 * @author Casper
	 * @date 2018年11月9日 下午10:10:03
	 * @param orderId
	 * @return
	 */
	public List<RequestDetailInfoDTO> getServiceDetailList(Long orderId);

	/**
	 * 根据病人编号查询病人从入院到出院的充值记录
	 * 
	 * @author Casper
	 * @date 2018年11月9日 下午10:35:50
	 * @param patientCode
	 * @return
	 */
	public List<TransactionInfoDTO> getTransactionList(Long orderId);

	/**
	 * 获取服务单的总金额
	 * 
	 * @author Casper
	 * @date 2018年11月9日 下午11:04:40
	 * @param orderId
	 * @return
	 */
	public Double getServiceTotalAmount(Long orderId, String endDate) throws DateParseException;

}
