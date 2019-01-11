/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.baseinfo 
 * @author: Casper   
 * @date: 2018年11月16日 上午10:06:13 
 */
package org.r.system.cs.dto.baseinfo;

import org.r.system.cs.util.dto.PageSizeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Casper
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SearchConditionDTO extends PageSizeDTO {

	// 编号
	private String code;
	// 姓名
	private String name;
	// 身份证
	private String idCard;
	// 性别
	private Integer sex;
	// 联系方式
	private String contact;
	// 联系地址
	private String address;
	// 联系人
	private String linkman;
	// 区间开始时间
	private String startDate;
	// 区间结束时间
	private String endDate;

}
