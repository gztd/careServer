/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.serviceimpl.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 上午9:22:32 
 */
package org.r.system.cs.serviceimpl.authorization;

import java.util.List;
import java.util.Map;

import org.r.system.cs.dao.authorization.AssociationDao;
import org.r.system.cs.service.authorization.DistributeService;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Casper
 *
 */
@Component
public class DistributeServiceImpl implements DistributeService {

	@Autowired
	private AssociationDao associationDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tongc.cs.service.authorization.DistributeServicce#createAssociation(java.
	 * lang.String, java.lang.Integer, java.util.List)
	 */
	@Transactional
	@Override
	public boolean createAssociation(String username, Integer project, List<Integer> role) {

		associationDao.insertAssociationFile(username, project, role, UtilTool.getSystemCurDateTime());

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tongc.cs.service.authorization.DistributeServicce#getAssociation(java.
	 * lang.String, java.lang.Integer)
	 */
	@Override
	public List<Map<String, Object>> getAssociation(String username, Integer project) {

		List<Map<String, Object>> result = null;
		if (project == null) {
			result = associationDao.selectProjectAssosciationFile(username);
		} else {
			result = associationDao.selectRoleAssociationFile(username, project);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tongc.cs.service.authorization.DistributeServicce#updateAssociation(java.
	 * lang.String, java.lang.Integer, java.util.List)
	 */
	@Transactional
	@Override
	public boolean modigyAssociation(String username, Integer project, List<Integer> role) {

		associationDao.deleteAssociationFile(username, project);
		associationDao.insertAssociationFile(username, project, role, UtilTool.getSystemCurDateTime());

		return true;
	}

}
