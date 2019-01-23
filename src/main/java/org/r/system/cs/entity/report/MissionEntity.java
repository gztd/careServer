package org.r.system.cs.entity.report;

import lombok.Data;

@Data
public class MissionEntity {

	// 任务单据编号
	private String code;
	// 陪护人员记录号
	private Long careworkerId;
	// 请求单编号
	private String requestCode;
	// 日期时间
	private String date;


}
