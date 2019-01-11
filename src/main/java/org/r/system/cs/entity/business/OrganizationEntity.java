package org.r.system.cs.entity.business;

import lombok.Data;

@Data
public class OrganizationEntity {

	// 科室记录号
	protected Integer id;
	// 组织编号
	protected String code;
	// 父组织编号
	protected Integer faId;
	// 组织名称
	protected String name;
	// 地理位置
	protected String address;
	// 联系方式
	protected String phone;
	// 负责人
	protected String principal;
	// 项目记录号
	protected Integer projectId;
	// 是否停用
	protected Boolean isDisabled;

}
