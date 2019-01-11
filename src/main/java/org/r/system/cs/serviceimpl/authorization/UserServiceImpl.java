/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.serviceimpl.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午11:20:47 
 */
package org.r.system.cs.serviceimpl.authorization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.r.system.cs.dao.authorization.UserFileDao;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.dto.authorization.UserDTO;
import org.r.system.cs.entity.authorization.UserFileEntity;
import org.r.system.cs.exception.authorization.FileNotFoundException;
import org.r.system.cs.service.authorization.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Casper
 *
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserFileDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tongc.cs.service.authorization.BaseService#createFile(java.lang.Object)
	 */
	@Override
	public boolean createFile(Object info) {

		UserDTO user = (UserDTO) info;
		if (userDao.insertUserFile(build(user)) == 0)
			return false;

		return true;
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

		if (userDao.updateUserFile(build((UserDTO) info)) == 0)
			throw new FileNotFoundException();

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
		
		List<Map<String, Object>> list = userDao.selectUserFileList(dto);
		Integer size = userDao.countUserFileListLength(dto);
		Map<String, Object> result = new HashMap<>();
		result.put("result", list);
		result.put("size", size);
		
		return result;
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
		UserFileEntity userFile = new UserFileEntity();
		userFile.setUsername((String) primaryKey);
		userFile.setIsDisabled(disable);
		if (userDao.updateUserFile(userFile) == 0)
			throw new FileNotFoundException("用户不存在");

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tongc.cs.service.authorization.UserService#lockUser(java.lang.String,
	 * boolean)
	 */
	@Override
	public boolean lockUser(String username, boolean lock) {
		return false;
	}

	private UserFileEntity build(UserDTO dto) {
		UserFileEntity file = new UserFileEntity();
		file.setIcon(dto.getIcon());
		file.setNickname(dto.getNickname());
		file.setPassword(dto.getPassword());
		file.setUsername(dto.getUsername());
		file.setIsDisabled(dto.getIsDisabled());
		file.setIsLocked(dto.getIsLocked());
		return file;
	}

	@Override
	public Object getFile(Object primaryKey) {

		return userDao.selectUserFile((String) primaryKey);
	}

}
