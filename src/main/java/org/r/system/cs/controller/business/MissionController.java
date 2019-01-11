package org.r.system.cs.controller.business;

import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.MissionDTO;
import org.r.system.cs.dto.business.MissionDetailInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.exception.business.FileInsertException;
import org.r.system.cs.exception.business.FileSelectException;
import org.r.system.cs.service.business.MissionService;
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
@RequestMapping("/api/busi/mission")
public class MissionController {

	@Autowired
	private MissionService missionService;

	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO adddispatch(@RequestBody MissionDTO info) {
		MsgDTO msg = null;

		if (info.getCareworkerIds() == null || info.getRequestCode() == null) {
			return new MsgDTO("400", "陪护人员/服务请求单编号不能为空");
		}

		try {
			missionService.createFile(info);
			msg = new MsgDTO("200", "派遣成功");
		} catch (FileInsertException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMessage());
		}

		return msg;
	}

	@InjectProjectId(value=SearchConditionDTO.class,propertyName="projectId")
	@RequestMapping(value = "/detail", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getMissionList(@RequestBody SearchConditionDTO info) {
		MsgDTO msg = null;
		if (info.getRequestCode() == null)
			return new MsgDTO("400", "查询任务详细信息时，服务请求单编号不能为空");

		try {
			ListDTO<MissionDetailInfoDTO> list = missionService.getMissionDetail(info);
			PageDTO page = new PageDTO(info.getPageSize(), info.getCurPage(), list.getSize());
			page.setResult(list.getResult());
			msg = new MsgDTO("200", page);
		} catch (FileSelectException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMessage());
		}
		return msg;
	}

	/**
	 * 查询派遣记录列表
	 * 
	 * @param info
	 * @return
	 */
	@InjectProjectId(value=SearchConditionDTO.class,propertyName="projectId")
	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getDispatchHistory(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;
		if (dto.getProjectId() == null)
			return new MsgDTO("400", "项目id不能为空");
		try {
			ListDTO<MissionDetailInfoDTO> list = missionService.getMissionList(dto);
			PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPageOrg(), list.getSize());
			page.setResult(list.getResult());
			msg = new MsgDTO("200", page);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMessage());
		}
		return msg;
	}
	
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.DELETE })
	public MsgDTO closeMission(@RequestParam(required=true) String requestCode, String date) {
		MsgDTO msg = null;
		if(requestCode == null)return new MsgDTO("400", "待结束的服务请求单编号不能为空");
		if(date == null || date == "")date = UtilTool.getSystemCurrentDateTime();
		
		try {
			missionService.closeMission(requestCode, date);
			msg = new MsgDTO("200", "结束任务完成");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMessage());
		}
		
		return msg;
	}

}
