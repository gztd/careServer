/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.entity.business 
 * @author: Casper   
 * @date: 2018年11月8日 下午10:10:28 
 */
package org.r.system.cs.entity.report;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Casper
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RequestDetailEntity extends RequestEntity {

	// 科室id
	protected Integer orgId;
	// 科室名称
	protected String orgName;
	// 陪护类型名称
	protected String careTypeName;
	// 陪护类型单价
	protected Double price;
	// 陪护类型属性
	private Integer property;
	// 结算类型
	private Integer settleType;
	// 工资计算系数
	private Float salaryIndex;
	// 入院时间
	private String hospitalDate;
	// 出院时间
	private String leaveDate;
	// 天数
	private Double days;
	// 服务金额
	private Double amount;
	// 预收款
	private Double pay;
	// 病人编号
	private String patientCode;
	// 病人姓名
	private String patientName;
	// 状态
	private String status;

}
