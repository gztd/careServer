/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.report 
 * @author: Casper   
 * @date: 2018年11月11日 上午10:28:05 
 */
package org.r.system.cs.dao.report;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.DutyEntity;

import java.util.List;

/**
 * @author Casper
 *
 */
@Mapper
public interface DutyFileReportDao {

	/**
	 * 根据条件查询值勤信息
	 * 
	 * @author Casper
	 * @date 2018年11月11日 上午10:29:59
	 * @param dto
	 * @return
	 */
	public List<DutyEntity> selectFileList(SearchConditionDTO dto);

}
