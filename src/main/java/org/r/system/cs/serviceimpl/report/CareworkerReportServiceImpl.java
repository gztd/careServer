/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午3:08:22 
 */
package org.r.system.cs.serviceimpl.report;

import org.r.system.cs.dao.report.CareworkerReportDao;
import org.r.system.cs.dto.report.CareworkerDetialDTO;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.service.report.CareworkerReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Casper
 *
 */
@Component
public class CareworkerReportServiceImpl implements CareworkerReportService {

	@Autowired
	private CareworkerReportDao careWorkerDao;
	
	@Override
	public Object getFile(Object primaryKey) {
		
		return null;
	}

	@Override
	public Map<String, Object> getFileList(SearchConditionDTO dto) {
		
		careWorkerDao.selectFileList(dto);
		
		return null;
	}
	
	public Map<String,Object> getFileList(Integer projectId,String date){
		SearchConditionDTO condition = new SearchConditionDTO();
		condition.setDate(date);
		condition.setProjectId(projectId);
		return getFileList(condition);
	}
	
	@Override
	public List<CareworkerDetialDTO> getCareworkerInOrg(Integer projectId, String date){
		
		SearchConditionDTO condition = new SearchConditionDTO();
		condition.setDate(date);
		condition.setProjectId(projectId);
		
		
		return careWorkerDao.selectCareworkDetail(condition);
	}

}
