/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.controller.authorization 
 * @author: Casper   
 * @date: 2018年11月5日 下午11:48:16 
 */
package org.r.system.cs.controller.authorization;

import org.r.system.cs.entity.authorization.ResourceEntity;
import org.r.system.cs.service.authorization.ResourceService;
import org.r.system.cs.util.dto.MsgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casper
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/aut/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getResourceList() {
		MsgDTO msg = null;
		msg = new MsgDTO("200", resourceService.getResourceList());
		return msg;
	}

	@RequestMapping(value = "module", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getModuleList(String username, Integer projectId) {
		MsgDTO msg = null;
		Object target = resourceService.getModule(username, projectId);
		if (target == null)
			msg = new MsgDTO("404", "用户没有该权限");
		else
			msg = new MsgDTO("200", resourceService.getModule(username, projectId));
		return msg;
	}
	
	
	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getResources() {
		MsgDTO msg = null;
		
		msg = new MsgDTO("200", resourceService.getResourcesList());
		
		return msg;
	}
	
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.PUT })
	public MsgDTO modifyResource(@RequestBody ResourceEntity info) {
		MsgDTO msg = null;
		
		try {
			resourceService.modifyResource(info);
			msg = new MsgDTO("200","成功");
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			msg = new MsgDTO("400", e.getMessage());
		}
		
		
		return msg;
	}
	
}
