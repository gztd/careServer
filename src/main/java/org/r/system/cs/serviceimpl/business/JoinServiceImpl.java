/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.business 
 * @author: Casper   
 * @date: 2018年11月11日 下午2:01:49 
 */
package org.r.system.cs.serviceimpl.business;

import java.util.List;

import org.r.system.cs.dao.business.JoinDao;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.JoinEntity;
import org.r.system.cs.exception.business.FileSelectException;
import org.r.system.cs.service.business.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Casper
 *
 */
@Component
public class JoinServiceImpl implements JoinService {

	@Autowired
	private JoinDao joinDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.r.system.cs.service.business.BaseService#getFile(java.lang.Object)
	 */
	@Override
	public Object getFile(Object primaryKey) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.BaseService#createFile(java.lang.Object)
	 */
	@Override
	public Object createFile(Object dto) {
		joinDao.insertFile(dto);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.business.BaseService#updateFile(java.lang.Object)
	 */
	@Override
	public void updateFile(Object dto) {
		joinDao.updateFile(dto);
	}

	@Override
	public ListDTO<JoinEntity> getFileList(SearchConditionDTO dto) {

		ListDTO<JoinEntity> result = new ListDTO<>();
		result.setResult(joinDao.selectFileList(dto));
		result.setSize(joinDao.countFileList(dto));

		return result;
	}

	@Override
	public JoinEntity getNewlyJoin(Long careworkerId) {

		SearchConditionDTO dto = new SearchConditionDTO();
		dto.setCareworkerId(careworkerId);
		dto.setIsNewly(true);
		List<JoinEntity> joins = joinDao.selectFileList(dto);
		if (joins.size() > 1 || joins.isEmpty())
			throw new FileSelectException("查询陪护人员最新入职记录，发现了多于一条的记录/没有该记录，检查搜索条件");
		

		return joins.get(0);
	}

}
