package org.r.system.cs.entity.report;

import lombok.Data;

@Data
public class CareworkerEntity {

	// 陪护人员记录号
	protected Long id;
	// 陪护人员编号
	protected String code;
	// 项目记录号
	protected String projectId;
	// 陪护人员姓名
	protected String name;


}
