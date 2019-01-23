/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.controller.report 
 * @author: Casper   
 * @date: 2018年11月15日 上午11:36:35 
 */
package org.r.system.cs.controller.report;

import lombok.extern.slf4j.Slf4j;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.service.report.OrgReportService;
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
@Slf4j
@RequestMapping("/api/report/org")
public class OrgReportController {

	@Autowired
	private OrgReportService orgReportService;

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getOrgReport(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;
		if (dto.getOrgId() == null || dto.getDate() == null)
			return new MsgDTO("400", "科室id和日期不能为空");

		try {
			msg = new MsgDTO("200", orgReportService.getOrgReportList(dto));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMessage());
		}

		return msg;
	}

}
