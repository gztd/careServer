/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午2:50:24 
 */
package org.r.system.cs.service.report;

import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.MissionEntity;

import java.util.List;

/**
 * @author Casper
 *
 */
public interface MissionReportService {

	/**
	 * 根据条件集合查询任务表列表
	 * 
	 * @author Casper
	 * @date 2018年11月11日 上午11:01:45
	 * @param dto
	 * @return
	 */
	public List<MissionEntity> getMissionFileList(SearchConditionDTO dto);

	/**
	 * 根据服务请求单编号集合查询任务表列表
	 * 
	 * @author Casper
	 * @date 2018年11月11日 上午11:01:45
	 * @param dto
	 * @return
	 */
	public List<MissionEntity> getMissionFileList(String requestCode);

}
