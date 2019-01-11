/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.authorization 
 * @author: Casper   
 * @date: 2018年11月19日 下午10:51:35 
 */
package org.r.system.cs.serviceimpl.authorization;

import java.util.HashMap;
import java.util.Map;

import org.r.system.cs.dao.authorization.OperationLogFileDao;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.service.authorization.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Casper
 *
 */
@Component
public class OperationLogServiceImpl implements OperationLogService {

	@Autowired
	private OperationLogFileDao fileDao;

	@Override
	public boolean createFile(Object info) {

		if (fileDao.insertFile(info) > 0)
			return true;

		return false;
	}

	@Override
	public boolean modifyFile(Object info) {
		return false;
	}

	@Override
	public Map<String, Object> getFileList(SearchConditionDTO dto) {

		Map<String, Object> result = new HashMap<>();
		result.put("result", fileDao.selectFileList(dto));
		result.put("size", fileDao.countList(dto));

		return result;
	}

	@Override
	public Object getFile(Object primaryKey) {
		return null;
	}

	@Override
	public boolean disableFile(Object primaryKey, boolean disable) {
		return false;
	}

}
