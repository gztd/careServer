package org.r.system.cs.entity.business;

import lombok.Data;

@Data
public class DutyInfoEntity {

	// 陪护人员记录号
	private Long careworkerId;
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
	//班次，默认1=白班，2=夜班
	private Integer schedule;
	//考勤性质，默认1=正常考勤，2=加班，3=请假
	private Integer property;

}
