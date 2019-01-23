/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.report 
 * @author: Casper   
 * @date: 2018年11月11日 上午12:20:42 
 */
package org.r.system.cs.dao.report;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.MissionEntity;

import java.util.List;

/**
 * @author Casper
 *
 */
@Mapper
public interface MissionReportDao {

	/**
	 * 查询任务单列表
	 * 
	 * @author Casper
	 * @date 2018年11月11日 上午12:21:43
	 * @param dto
	 * @return
	 */
	public List<MissionEntity> selectMissionList(SearchConditionDTO dto);

}
