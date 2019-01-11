/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月9日 上午9:27:31 
 */
package org.r.system.cs.dto.business;

import org.r.system.cs.util.dto.PageSizeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Casper
 *
 */
@Data()
@EqualsAndHashCode(callSuper=false)
public class SearchConditionDTO extends PageSizeDTO{

	// 编号
	private String code;
	// 姓名
	private String name;
	// 身份证
	private String idCard;
	// 联系方式
	private String contact;
	// 科室id
	private Integer orgId;
	// 区间开始时间
	private String startDate;
	// 区间结束时间
	private String endDate;
	// 服务单id
	private Long orderId;
	// 服务请求单编号
	private String requestCode;
	// 是否最新
	private Boolean isNewly;
	// 是否在职
	private Boolean isOnWork;
	// 是否停用
	private Boolean isDisabled;
	// 是否住院
	private Boolean isOnHospital;
	// 项目id
	private Integer projectId;
	// 陪护人员id
	private Long careworkerId;
	// 陪护人员姓名
	private String careworkerName;
	// 陪护人员编号
	private String careworkerCode;
	// 陪护类型属性
	private Integer property;
	
	

}
