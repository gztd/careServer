/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月11日 下午2:48:42 
 */
package org.r.system.cs.dto.business;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class CareworkerInfoDTO {

	// 入职时间
	private String startDateTime;
	// 离职时间
	private String endDateTime;
	// 科室记录号
	private Integer orgId;
	// 科室名称
	private String orgName;
	// 陪护人员id
	private Long careworkerId;
	// 陪护人员姓名
	private String name;
	// 陪护人员编号
	private String code;
	// 项目id
	private Integer projectId;

}
