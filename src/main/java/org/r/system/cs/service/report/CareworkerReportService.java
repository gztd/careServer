/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午2:50:40 
 */
package org.r.system.cs.service.report;

import org.r.system.cs.dto.report.CareworkerDetialDTO;

import java.util.List;

/**
 * @author Casper
 *
 */
public interface CareworkerReportService extends BaseService {

	/**
	 * 获取陪护人员信息，附带所属科室
	 * 
	 * @author Casper
	 * @date 2018年11月10日 下午3:58:39
	 * @return
	 */
	public List<CareworkerDetialDTO> getCareworkerInOrg(Integer projectId, String date);

}
