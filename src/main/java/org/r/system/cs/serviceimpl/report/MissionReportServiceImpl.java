/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.report 
 * @author: Casper   
 * @date: 2018年11月11日 上午12:19:32 
 */
package org.r.system.cs.serviceimpl.report;

import org.r.system.cs.dao.report.MissionReportDao;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.MissionEntity;
import org.r.system.cs.service.report.MissionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Casper
 *
 */
@Component
public class MissionReportServiceImpl implements MissionReportService {

	@Autowired
	private MissionReportDao missionDao;
	
	
	/* (non-Javadoc)
	 * @see org.r.system.cs.service.report.MissionService#getMissionFileList(org.r.system.cs.dto.report.SearchConditionDTO)
	 */
	@Override
	public List<MissionEntity> getMissionFileList(SearchConditionDTO dto) {
		
		return missionDao.selectMissionList(dto);
	}

	/* (non-Javadoc)
	 * @see org.r.system.cs.service.report.MissionService#getMissionFileList(java.lang.String)
	 */
	@Override
	public List<MissionEntity> getMissionFileList(String requestCode) {
		SearchConditionDTO dto = new SearchConditionDTO();
		dto.setCode(requestCode);
		return getMissionFileList(dto);
	}

}
