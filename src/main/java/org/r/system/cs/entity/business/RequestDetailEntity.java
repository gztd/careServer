/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.entity.business 
 * @author: Casper   
 * @date: 2018年11月8日 下午10:10:28 
 */
package org.r.system.cs.entity.business;

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
	// 天数
	protected Double days;
	// 金额
	protected Double amount;

}
