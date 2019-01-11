/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.controller.authorization 
 * @author: Casper   
 * @date: 2018年11月5日 下午6:32:13 
 */
package org.r.system.cs.controller.authorization;

import org.r.system.cs.dto.authorization.AssociationDTO;
import org.r.system.cs.service.authorization.DistributeService;
import org.r.system.cs.util.dto.MsgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Casper
 *
 */
@RestController
@RequestMapping("/api/aut/association")
public class AssociationController {

	@Autowired
	private DistributeService distributeService;

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO addAssociation(@RequestBody AssociationDTO dto) {
		MsgDTO msg = null;
		distributeService.createAssociation(dto.getUsername(), dto.getBusinessDbId(), dto.getRoleIds());
		msg = new MsgDTO("200", "创建成功");
		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.PUT })
	public MsgDTO modifyAssociation(@RequestBody AssociationDTO dto) {
		MsgDTO msg = null;
		distributeService.modigyAssociation(dto.getUsername(), dto.getBusinessDbId(), dto.getRoleIds());
		msg = new MsgDTO("200", "修改成功");
		return msg;
	}

	@RequestMapping(value = "/project", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getProjectAssociation(String username) {
		MsgDTO msg = null;
		msg = new MsgDTO("200", distributeService.getAssociation(username, null));
		return msg;
	}

	@RequestMapping(value = "/role", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getRoleAssociation(String username, Integer projectId) {
		MsgDTO msg = null;
		msg = new MsgDTO("200", distributeService.getAssociation(username, projectId));
		return msg;
	}

}
