package org.r.system.cs.dto.business;

import org.r.system.cs.dto.baseinfo.EmployeeDTO;

import lombok.Data;

@Data
public class EntryDTO {

	// 陪护人员id
	private Long careworkerId;
	// 入职时间
	private String startDateTime;
	// 离职时间
	private String endDateTime;
	// 项目记录号
	private Integer projectId;
	// 科室记录号
	private Integer orgId;
	// 科室名称
	private String orgName;
	// 员工基本信息对象
	private EmployeeDTO employee;

}
