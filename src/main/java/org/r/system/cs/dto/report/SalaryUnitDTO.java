/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午2:34:16 
 */
package org.r.system.cs.dto.report;

import lombok.Data;

import java.util.List;

/**
 * @author Casper
 *
 */
@Data
public class SalaryUnitDTO {

	// 科室名称
	private String orgName;
	// 陪护人员工资详情
	private List<SalaryCellDTO> careworkers;

}
