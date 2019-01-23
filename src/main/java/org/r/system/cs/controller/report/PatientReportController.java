/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.controller.report 
 * @author: Casper   
 * @date: 2018年11月15日 上午12:41:23 
 */
package org.r.system.cs.controller.report;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.entity.report.RequestDetailEntity;
import org.r.system.cs.exception.report.SalaryException;
import org.r.system.cs.service.report.ExportFileService;
import org.r.system.cs.service.report.PatientReportService;
import org.r.system.cs.serviceimpl.report.PatientReportExcelExportService;
import org.r.system.cs.util.annotation.InjectProjectId;
import org.r.system.cs.util.dto.MsgDTO;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Casper
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/report/patient")
public class PatientReportController {

	@Autowired
	private PatientReportService patientReportService;

	@InjectProjectId(value=SearchConditionDTO.class,propertyName="projectId")
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getReport(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;

		if (dto.getProjectId() == null || dto.getDate() == null || dto.getDate() == "")
			return new MsgDTO("400", "项目id和时间不能为空");
		try {
			msg = new MsgDTO("200", patientReportService.getRequestDetailList(dto));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMessage());
		}

		return msg;
	}
	
	@InjectProjectId(value=SearchConditionDTO.class,propertyName="projectId")
	@RequestMapping(value = "/file", method = { RequestMethod.GET, RequestMethod.POST })
	public MsgDTO exportFile(@RequestBody SearchConditionDTO dto, HttpServletResponse resp) {
		MsgDTO msg = null;
		ExportFileService fileService = new PatientReportExcelExportService();
		if (dto == null || dto.getProjectId() == null || dto.getDate() == null || dto.getDate().isEmpty())
			return new MsgDTO("400", "项目id和时间不能为空");
		try {
			List<RequestDetailEntity> list = patientReportService.getRequestDetailList(dto);

			SXSSFWorkbook web = (SXSSFWorkbook) fileService.exportFile(list);

			resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			String fileName = UtilTool.getSystemCurrentDate() + ".xlsx";
			resp.setHeader("Content-disposition", "attachment;filename=" + fileName);
			OutputStream ouputStream = resp.getOutputStream();
			web.write(ouputStream);
			ouputStream.flush();
			ouputStream.close();
			web.close();

			msg = new MsgDTO("200", null);
		} catch (SalaryException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMessage());
		}
		return msg;
	}


}
