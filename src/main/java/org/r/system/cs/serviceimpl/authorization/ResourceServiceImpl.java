/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.authorization 
 * @author: Casper   
 * @date: 2018年11月5日 下午11:52:25 
 */
package org.r.system.cs.serviceimpl.authorization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.r.system.cs.dao.authorization.ResourceDao;
import org.r.system.cs.entity.authorization.ResourceEntity;
import org.r.system.cs.service.authorization.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Casper
 *
 */
@Component
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceDao resourceDao;

	/* (non-Javadoc)
	 * @see org.r.system.cs.service.authorization.ResourceService#getResourceList()
	 */
	@Override
	public List<Map<String, Object>> getResourceList() {
		
		return resourceDao.selectResouceList();
	}

	/* (non-Javadoc)
	 * @see org.r.system.cs.service.authorization.ResourceService#getModule(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Object getModule(String username, Integer projectId) {
		
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		
		if(!username.equals("admin")&&projectId == null)return null;
		
		List<Map<String, Object>> modules = resourceDao.selectModule(username, projectId);
		
		for(Map<String, Object> tmp : modules) {
			
			Map<String, Object> meta = new HashMap<>();
			meta.put("keepAlive", false);
			meta.put("requireAuth", true);
			List<Map<String, Object>> child=resourceDao.selectFunction(username, projectId, (Integer) tmp.get("id"));
			Map<String, Object> module = new HashMap<>();
			List<Map<String, Object>> child2=new ArrayList<>();
			
			for (Map<String, Object> map : child) {
				Map<String, Object> lis=new HashMap<>();
				lis.put("id", map.get("id"));
				lis.put("name", map.get("name"));
				lis.put("path", map.get("path"));
				lis.put("component", map.get("component"));
				lis.put("meta", meta);
				lis.put("children", new ArrayList<>());
				child2.add(lis);				
				module.put("children", child2);				
			}
			module.put("id", tmp.get("id"));
			module.put("name", tmp.get("name"));
			module.put("component", "Home");
			module.put("path", "/home");
			module.put("meta", meta);
			result.add(module);
			
		}
		
		return result;
	}
	
	
//	private Object getAdminModule(String username) {
//		
//		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
//		
//		
//		return null;
//	}

	@Override
	public List<ResourceEntity> getResourcesList() {
		
		
		return resourceDao.selectResourcesList();
	}

	@Override
	public void modifyResource(ResourceEntity info) {
		resourceDao.updateFile(info);
		
	}

}
