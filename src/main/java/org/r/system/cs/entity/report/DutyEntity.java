/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.entity.report 
 * @author: Casper   
 * @date: 2018年11月11日 上午10:03:11 
 */
package org.r.system.cs.entity.report;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class DutyEntity {

	// 陪护人员记录号
	private Integer careworkerId;
	// 日
	private String day;
	// 月
	private String month;
	// 年
	private String year;
	// 值勤系数
	private Integer dayIndex;
	// 是否上班
	private Boolean isWorked;
	// 班次，默认1=白班，2=夜班
	private Integer schedule;
	// 考勤性质，默认1=正常考勤，2=加班，3=请假
	private Integer property;

}
