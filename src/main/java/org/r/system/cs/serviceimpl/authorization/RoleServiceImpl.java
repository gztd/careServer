/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.serviceimpl.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午11:21:53 
 */
package org.r.system.cs.serviceimpl.authorization;

import java.util.HashMap;
import java.util.Map;

import org.r.system.cs.dao.authorization.OwnFileDao;
import org.r.system.cs.dao.authorization.RoleFileDao;
import org.r.system.cs.dto.authorization.RoleDTO;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.entity.authorization.RoleFileEntity;
import org.r.system.cs.exception.authorization.FileInsertException;
import org.r.system.cs.exception.authorization.FileNotFoundException;
import org.r.system.cs.service.authorization.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Casper
 *
 */
@Component
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleFileDao roleDao;

	@Autowired
	private OwnFileDao ownDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tongc.cs.service.authorization.BaseService#createFile(java.lang.Object)
	 */
	@Transactional
	@Override
	public boolean createFile(Object info) {

		RoleDTO dto = (RoleDTO) info;
		RoleFileEntity role = build(dto);

		if (roleDao.insertRoleFile(role) == 0)
			throw new FileInsertException("插入角色记录异常，数据库异常");

		if (ownDao.insertOwnFile(role.getId(), dto.getAuths()) != dto.getAuths().size())
			throw new FileInsertException("角色赋权异常，数据库异常");

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

		RoleDTO dto = (RoleDTO) info;
		RoleFileEntity role = build(dto);

		ownDao.deleteOwnFile(dto.getId(), null);
		roleDao.updateRoleFile(role);
		ownDao.insertOwnFile(dto.getId(), dto.getAuths());
		return true;
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
		result.put("result", roleDao.selectRoleFileList(dto));
		result.put("size", roleDao.countRoleFileListLength(dto));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tongc.cs.service.authorization.BaseService#getFile(java.lang.Object)
	 */
	@Override
	public Object getFile(Object primaryKey) {

		Map<String, Object> result = new HashMap<>();
		result.put("role", roleDao.selectRoleFile((Integer) primaryKey));
		result.put("auths", ownDao.selectOwnFile((Integer) primaryKey));
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tongc.cs.service.authorization.BaseService#disable(java.lang.Object,
	 * boolean)
	 */
	@Override
	public boolean disableFile(Object primaryKey, boolean disable) {
		RoleFileEntity role = new RoleFileEntity();
		role.setId((Integer) primaryKey);
		role.setIsDisabled(disable);
		if (roleDao.updateRoleFile(role) == 0)
			throw new FileNotFoundException("角色不存在");
		return true;
	}

	/**
	 * 用角色DTO建立角色实体
	 * 
	 * @author Casper
	 * @date 2018年11月5日 上午11:53:54
	 * @param dto
	 * @return 角色实体
	 */
	private RoleFileEntity build(RoleDTO dto) {
		RoleFileEntity file = new RoleFileEntity();
		file.setId(dto.getId());
		file.setIsDisabled(dto.getIsDisabled());
		file.setRoleName(dto.getRoleName());
		return file;
	}

}
