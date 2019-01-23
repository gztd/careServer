/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午2:35:48 
 */
package org.r.system.cs.dto.report;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class SalaryCellDTO {

	// 陪护人员名称
	private String name;
	// 陪护人员职位名称
	private String jobName;
	// 计发天数
	private Integer countDay = 0;
	// 实发工资
	private Double salary = 0.0;
	// 奖励工资
	private Double reward = 0.0;
	// 合计工资
	private Double total = 0.0;

}
