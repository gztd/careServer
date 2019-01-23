/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午3:15:48 
 */
package org.r.system.cs.dto.report;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class SearchConditionDTO {

	// 项目id
	private Integer projectId;
	// 日期
	private String date;
	// 科室id
	private Integer orgId;
	// 服务单id
	private Long orderId;
	// 是否最新
	private Boolean isNewly;
	// 编号
	private String code;
	//陪护人员id
	private Long careworkerId;
}
