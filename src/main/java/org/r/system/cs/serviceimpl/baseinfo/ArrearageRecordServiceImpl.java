/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.serviceimpl 
 * @author: Casper   
 * @date: 2018年10月30日 下午8:11:39 
 */
package org.r.system.cs.serviceimpl.baseinfo;

import org.r.system.cs.dao.baseinfo.ArrearageRecordDao;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
import org.r.system.cs.service.baseinfo.ArrearageRecordService;
import org.r.system.cs.util.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Casper
 *
 */
@Component
public class ArrearageRecordServiceImpl implements ArrearageRecordService {
	
	@Autowired
	private ArrearageRecordDao dao;

	/* (non-Javadoc)
	 * @see com.gztc.cs.baseinfo.patient.service.ArrearageRecordService#getArrearageList(com.gztc.cs.baseinfo.patient.util.SearchConditionDTO)
	 */
	@Override
	public PageDTO getArrearageList(SearchConditionDTO dto) {
		PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPageOrg(), dao.countArrearageListLength(dto));
		page.setResult(dao.selectArrearageList(dto));
		return page;
	}

}
