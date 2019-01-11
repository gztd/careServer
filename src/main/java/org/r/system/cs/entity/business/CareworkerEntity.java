package org.r.system.cs.entity.business;

import lombok.Data;

@Data
public class CareworkerEntity {

	// 陪护人员记录号
	private Long id;
	// 陪护人员编号
	private String code;
	// 项目记录号
	private Integer projectId;
	// 陪护人员姓名
	private String name;

}
