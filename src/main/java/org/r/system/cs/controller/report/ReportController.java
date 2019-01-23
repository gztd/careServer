/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.controller.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午2:31:19 
 */
package org.r.system.cs.controller.report;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.r.system.cs.dto.report.SalaryUnitDTO;
import org.r.system.cs.dto.report.SearchConditionDTO;
import org.r.system.cs.exception.report.SalaryException;
import org.r.system.cs.service.report.ExportFileService;
import org.r.system.cs.service.report.SalaryService;
import org.r.system.cs.serviceimpl.report.SalaryExcelFileExportService;
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
@RequestMapping("/api/report/salary")
@Slf4j
public class ReportController {

	@Autowired
	private SalaryService salaryService;

	@InjectProjectId(value=SearchConditionDTO.class,propertyName="projectId")
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getCareWorkerSalaryReport(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;
		if (dto == null || dto.getProjectId() == null || dto.getDate() == null || dto.getDate().isEmpty())
			return new MsgDTO("400", "项目id和时间不能为空");

		try {
			List<SalaryUnitDTO> list = salaryService.getCareWorkerSalary(dto.getProjectId(), dto.getDate());
			msg = new MsgDTO("200", list);
		} catch (SalaryException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
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
		ExportFileService fileService = new SalaryExcelFileExportService();
		if (dto == null || dto.getProjectId() == null || dto.getDate() == null || dto.getDate().isEmpty())
			return new MsgDTO("400", "项目id和时间不能为空");
		try {
			List<SalaryUnitDTO> list = salaryService.getCareWorkerSalary(dto.getProjectId(), dto.getDate());

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
