/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.controller.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午8:07:15 
 */
package org.r.system.cs.controller.authorization;

import java.util.Map;

import org.r.system.cs.dto.authorization.ProjectDTO;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.service.authorization.ProjectService;
import org.r.system.cs.util.dto.MsgDTO;
import org.r.system.cs.util.dto.PageDTO;
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
@RequestMapping("/api/aut/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO addProject(@RequestBody ProjectDTO dto) {
		MsgDTO msg = null;
		if(dto.getName() == null) {
			msg = new MsgDTO("400", "项目名不能为空");
			return msg;
		}
		try {
			projectService.createFile(dto);
			msg = new MsgDTO("200", "创建成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.PUT })
	public MsgDTO modifyProject(@RequestBody ProjectDTO dto) {
		MsgDTO msg = null;
		
		if(dto.getId() == null) {
			msg = new MsgDTO("400", "项目id不能为空");
			return msg;
		}

		try {
			projectService.modifyFile(dto);
			msg = new MsgDTO("200", "修改成功");
		} catch (Exception e) {
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.DELETE })
	public MsgDTO disableProject(Integer projectId,Boolean disable) {
		MsgDTO msg = null;
		if(projectId == null || disable == null) {
			msg = new MsgDTO("400", "项目id/状态不能为空");
			return msg;
		}
		
		try {
			projectService.disableFile(projectId, disable);
			msg = new MsgDTO("200", "禁用成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		
		return msg;
	}

	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getProjectList(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;
		Map<String, Object> result = projectService.getFileList(dto);
		PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPageOrg(), (Integer) result.get("size"));
		page.setResult(result.get("result"));
		msg = new MsgDTO("200", page);
		return msg;
		
	}
}
