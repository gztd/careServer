package org.r.system.cs.entity.business;

import lombok.Data;

@Data
public class CareTypeEntity {

	// 记录号
	protected Integer id;
	// 名称
	protected String name;
	// 价格
	protected Double price;
	// 工资计算系数
	protected Double salaryIndex;
	// 是否默认
	protected Boolean isDefault;
	// 陪护属性,1=一对一,2=一对多,3=多对多
	protected Integer property;
	// 结算方式,1=日，2=例
	protected Integer settleType;
	// 项目记录号
	protected Integer projectId;


}
