/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月8日 下午8:30:02 
 */
package org.r.system.cs.dto.business;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class LeaveDTO {

	// 服务单编号
	private String hospitalCode;
	// 出院时间
	private String dateTime;
	// 退款金额
	private Double money;
	// 退款接收人
	private String payMan;

}
