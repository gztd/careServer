/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.report 
 * @author: Casper   
 * @date: 2018年11月15日 下午12:56:44 
 */
package org.r.system.cs.dto.report;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class OrgReportDTO {

	// 日期，年月日
	private String date;
	// 收入
	private Double income;
	// 支出
	private Double expend;

}
