/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午2:49:58 
 */
package org.r.system.cs.service.report;

import org.r.system.cs.dto.report.SalaryUnitDTO;

import java.util.List;

/**
 * @author Casper
 *
 */
public interface SalaryService {

	/**
	 * 获取陪护人员工资报表
	 * 
	 * @author Casper
	 * @date 2018年11月10日 下午2:56:23
	 * @return
	 */
	public List<SalaryUnitDTO> getCareWorkerSalary(Integer projectId, String date);

}
