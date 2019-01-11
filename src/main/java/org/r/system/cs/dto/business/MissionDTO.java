package org.r.system.cs.dto.business;

import java.util.List;

import lombok.Data;

@Data
public class MissionDTO {
   
	//任务单据编号
	private String code;
	//陪护人员记录号
	private Long careworkerId;
	//请求单编号
	private String requestCode;
	//日期时间
	private String dateTime;
	//陪护人员记录号
	private List<Long> careworkerIds;
	
}
