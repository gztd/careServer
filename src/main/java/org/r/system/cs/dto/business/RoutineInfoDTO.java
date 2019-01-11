/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月11日 下午10:17:03 
 */
package org.r.system.cs.dto.business;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class RoutineInfoDTO {

	// 班次，默认1=白班，2=夜班
	private String schedule;
	// 考勤性质，默认1=正常考勤，2=加班，3=请假
	private String property;
	// 值班日期
	private String date;
	// 值勤系数
	private Integer dayIndex;
	// 是否上班
	private Boolean isWorked;

}
