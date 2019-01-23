/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午3:11:55 
 */
package org.r.system.cs.dao.report;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.report.CareworkerDetialDTO;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.CareworkerEntity;

import java.util.List;

/**
 * @author Casper
 *
 */
@Mapper
public interface CareworkerReportDao extends BaseDao {

	/**
	 * 条件分页查询记录列表
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午4:05:13
	 * @param dto
	 * @return
	 */
	public List<CareworkerEntity> selectFileList(SearchConditionDTO dto);

	public List<CareworkerDetialDTO> selectCareworkDetail(SearchConditionDTO dto);
	
}
