package org.r.system.cs.controller.business;

import org.r.system.cs.dto.business.CareworkerInfoDTO;
import org.r.system.cs.dto.business.EntryDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.exception.business.EntryException;
import org.r.system.cs.exception.business.FileSelectException;
import org.r.system.cs.service.business.CareworkerService;
import org.r.system.cs.util.annotation.InjectProjectId;
import org.r.system.cs.util.dto.MsgDTO;
import org.r.system.cs.util.dto.PageDTO;
import org.r.system.cs.util.tool.UtilTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/busi/careworker")
public class CareworkerController {

	@Autowired
	private CareworkerService careworkerService;

	/**
	 * 员工入职
	 * 
	 * @param info
	 * @return
	 */
	@InjectProjectId(value = EntryDTO.class, propertyName = "projectId")
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO entry(@RequestBody EntryDTO info) {
		MsgDTO msg = null;
		if (info.getOrgId() == null || info.getProjectId() == null || info.getEmployee() == null)
			return new MsgDTO("400", "科室id、项目id和员工信息不能为空");

		if (info.getEmployee().getCode() == "")
			info.getEmployee().setCode(null);

		if (info.getStartDateTime() == null)
			info.setStartDateTime(UtilTool.getSystemCurrentDateTime());

		try {
			msg = new MsgDTO("200", careworkerService.entry(info));

		} catch (EntryException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	/**
	 * 员工离职
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.DELETE })
	public MsgDTO leave(String endDateTime, Long careworkerId) {
		MsgDTO msg = null;

		if (careworkerId == null)
			return new MsgDTO("400", "陪护人员id和离职时间不能为空");
		if (endDateTime == null || endDateTime.isEmpty())
			endDateTime = UtilTool.getSystemCurrentDateTime();

		try {
			careworkerService.leave(careworkerId, endDateTime);
			msg = new MsgDTO("200", "离职流程完成");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.PUT })
	public MsgDTO change(@RequestBody EntryDTO info) {
		MsgDTO msg = null;
		if (info.getCareworkerId() == null || info.getStartDateTime() == null || info.getOrgId() == null)
			return new MsgDTO("400", "陪护人员id/时间/科室id不能为空");
		try {
			careworkerService.change(info);
			msg = new MsgDTO("200", "变更成功");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMessage());
		}

		return msg;
	}

	/**
	 * 查询陪护人员信息列表
	 * 
	 * @param info
	 * @return
	 */
	@InjectProjectId(value = SearchConditionDTO.class, propertyName = "projectId")
	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getCareworkerList(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;
		try {
			ListDTO<CareworkerInfoDTO> result = careworkerService.getCareworkerInfoList(dto);
			PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPage(), result.getSize());
			page.setResult(result.getResult());
			msg = new MsgDTO("200", page);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	/***
	 * 根据陪护人员编号查询陪护人员的详细信息
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.GET })
	public MsgDTO getCareworkerDetail(@RequestParam Long careworkerId) {
		MsgDTO msg = null;
		if (careworkerId == null) {
			return new MsgDTO("400", "陪护人员id不能为空");
		}

		try {
			msg = new MsgDTO("200", careworkerService.getFile(careworkerId));
		} catch (FileSelectException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

}
