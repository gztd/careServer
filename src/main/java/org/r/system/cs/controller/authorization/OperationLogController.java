/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.controller.authorization 
 * @author: Casper   
 * @date: 2018年11月19日 下午7:25:43 
 */
package org.r.system.cs.controller.authorization;

import java.util.Map;

import org.r.system.cs.dto.authorization.SearchConditionDTO;
import org.r.system.cs.service.authorization.OperationLogService;
import org.r.system.cs.util.dto.MsgDTO;
import org.r.system.cs.util.dto.PageDTO;
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
@RequestMapping("/api/aut/log")
@Slf4j
public class OperationLogController {

	@Autowired
	private OperationLogService operationService;

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getLogList(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;

		try {
			Map<String, Object> result = operationService.getFileList(dto);
			PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPageOrg(), (Integer) result.get("size"));
			page.setResult(result.get("result"));
			msg = new MsgDTO("200", page);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMessage());
		}

		return msg;
	}

}
