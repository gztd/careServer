/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.controller.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午8:06:50 
 */
package org.r.system.cs.controller.authorization;

import java.util.Map;

import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.dto.authorization.UserDTO;
import org.r.system.cs.exception.authorization.FileNotFoundException;
import org.r.system.cs.service.authorization.UserService;
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
@RequestMapping("/api/aut/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO addUser(@RequestBody UserDTO dto) {
		MsgDTO msg = null;
		if (userService.createFile(dto)) {
			msg = new MsgDTO("200", "创建成功");
		} else {
			msg = new MsgDTO("400", "创建失败");
		}
		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.PUT })
	public MsgDTO modifyUser(@RequestBody UserDTO dto) {
		MsgDTO msg = null;

		if (dto.getUsername() == null) {
			msg = new MsgDTO("400", "用户名不能为空");
			return msg;
		}

		try {
			userService.modifyFile(dto);
			msg = new MsgDTO("200", "修改完成");
		} catch (FileNotFoundException e) {
			msg = new MsgDTO("400", "修改的用户不存在");
		} catch (Exception e) {
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.DELETE })
	public MsgDTO disableUser(String username, Boolean disable) {
		MsgDTO msg = null;

		if (username == null || username == "") {
			msg = new MsgDTO("400", "用户名不能为空");
			return msg;
		}

		try {
			userService.disableFile(username, disable);
			msg = new MsgDTO("200", "成功");
		} catch (Exception e) {
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getUser(String username) {
		MsgDTO msg = null;
		if (username == null || username == "") {
			msg = new MsgDTO("400", "用户名不能为空");
			return msg;
		}

		msg = new MsgDTO("200", userService.getFile(username));

		return msg;
	}

	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = { RequestMethod.GET,
			RequestMethod.POST })
	public MsgDTO getUserList(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;
		Map<String, Object> result = userService.getFileList(dto);
		PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPageOrg(), (Integer) result.get("size"));
		page.setResult(result.get("result"));
		msg = new MsgDTO("200", page);
		return msg;
	}

}
