package org.r.system.cs.dto.business;

import java.util.List;

import lombok.Data;

@Data
public class DutyInfoDTO {

	// 陪护人员记录号
	private List<Long> careworkerIds;
	// 日期
	private String date;
	// 值勤系数
	private Integer dayIndex;
	// 是否上班
	private Boolean isWorked;
	// 班次，默认1=白班，2=夜班
	private Integer schedule;
	// 考勤性质，默认1=正常考勤，2=加班，3=请假
	private Integer property;

}
