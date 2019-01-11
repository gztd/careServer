/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.controller.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午8:07:01 
 */
package org.r.system.cs.controller.authorization;

import java.util.Map;

import org.r.system.cs.dto.authorization.RoleDTO;
import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.service.authorization.RoleService;
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
@RequestMapping("/api/aut/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO addRole(@RequestBody RoleDTO dto) {
		MsgDTO msg = null;

		if (dto.getRoleName() == null || dto.getAuths() == null || dto.getAuths().isEmpty()) {
			msg = new MsgDTO("400", "角色名称/资源id不能为空");
			return msg;
		}

		try {
			roleService.createFile(dto);
			msg = new MsgDTO("200", "创建成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.PUT })
	public MsgDTO modifyRole(@RequestBody RoleDTO dto) {
		MsgDTO msg = null;
		if (dto.getId() == null || dto.getAuths() == null || dto.getAuths().isEmpty()) {
			msg = new MsgDTO("400", "角色id/资源id不能为空");
			return msg;
		}

		try {
			roleService.modifyFile(dto);
			msg = new MsgDTO("200", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.DELETE })
	public MsgDTO disableRole(Integer id, Boolean disable) {
		MsgDTO msg = null;

		if (id == null) {
			msg = new MsgDTO("400", "ID不能为空");
			return msg;
		}

		try {
			roleService.disableFile(id, disable);
			msg = new MsgDTO("200", "禁用成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = { RequestMethod.GET,
			RequestMethod.POST })
	public MsgDTO getRoleList(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;

		Map<String, Object> result = roleService.getFileList(dto);

		PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPageOrg(), (Integer) result.get("size"));
		page.setResult(result.get("result"));
		msg = new MsgDTO("200", page);

		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getRole(Integer id) {
		MsgDTO msg = null;
		if (id == null) {
			msg = new MsgDTO("400", "id不能为空");
			return msg;
		}

		try {
			msg = new MsgDTO("200", roleService.getFile(id));
		} catch (Exception e) {
			e.printStackTrace();
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

}
