/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.entity.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:40:58 
 */
package org.r.system.cs.entity.business;

import java.sql.Timestamp;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class RequestEntity {

	// 请求单编号
	protected String code;
	// 服务单id
	protected Long orderId;
	// 陪护类型id
	protected Integer careTypeId;
	// 服务开始时间
	private Timestamp startDateTime;
	// 服务结束时间
	private Timestamp endDateTime;
	// 床位
	protected String bedNum;
	// 经手人
	protected String clerk;
	//科室id
	protected Integer orgId;

}
