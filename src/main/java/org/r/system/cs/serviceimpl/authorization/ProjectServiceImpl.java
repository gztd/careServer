/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.serviceimpl.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午11:23:50 
 */
package org.r.system.cs.serviceimpl.authorization;

import java.util.HashMap;
import java.util.Map;

import org.r.system.cs.dao.authorization.ProjectFileDao;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.entity.authorization.ProjectFileEntity;
import org.r.system.cs.exception.authorization.FileNotFoundException;
import org.r.system.cs.service.authorization.ProjectService;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Casper
 *
 */
@Component
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectFileDao projectDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tongc.cs.service.authorization.BaseService#createFile(java.lang.Object)
	 */
	@Transactional
	@Override
	public boolean createFile(Object info) {
		ProjectFileEntity file = (ProjectFileEntity) info;
		file.setUrl("localhost");
		file.setDriver("com.mysql.jdbc.Driver");
		file.setUsername("root");
		file.setPassword("toor");
		file.setCode("PR" + System.currentTimeMillis());
		file.setCreateTime(UtilTool.getSystemCurDateTime());
		return projectDao.insertProjectFile(file) != 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tongc.cs.service.authorization.BaseService#updateFile(java.lang.Object)
	 */
	@Transactional
	@Override
	public boolean modifyFile(Object info) {
		if (projectDao.updateProjectFile((ProjectFileEntity) info) == 0)
			throw new FileNotFoundException("修改的项目不存在");

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tongc.cs.service.authorization.BaseService#getFileList(org.r.util.dto.
	 * SearchConditionDTO)
	 */
	@Override
	public Map<String, Object> getFileList(SearchConditionDTO dto) {
		Map<String, Object> result = new HashMap<>();
		result.put("size", projectDao.countProjectFileListLength(dto));
		result.put("result", projectDao.selectProjectFileList(dto));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tongc.cs.service.authorization.BaseService#getFile(java.lang.Object)
	 */
	@Override
	public Object getFile(Object primaryKey) {

		return projectDao.selectProjectFile((Integer) primaryKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tongc.cs.service.authorization.BaseService#disable(java.lang.Object,
	 * boolean)
	 */
	@Transactional
	@Override
	public boolean disableFile(Object primaryKey, boolean disable) {
		ProjectFileEntity file = new ProjectFileEntity();
		file.setId((Integer) primaryKey);
		file.setIsDisabled(disable);
		projectDao.updateProjectFile(file);
		return true;
	}

}
