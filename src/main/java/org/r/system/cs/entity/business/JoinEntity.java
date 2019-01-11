package org.r.system.cs.entity.business;

import lombok.Data;

@Data
public class JoinEntity {

	// 陪护人员id
	private Long careworkerId;
	// 科室id
	private Integer orgId;
	// 入职时间
	private String startDateTime;
	// 离职时间
	private String endDateTime;

}
