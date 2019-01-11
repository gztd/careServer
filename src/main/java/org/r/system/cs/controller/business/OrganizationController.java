package org.r.system.cs.controller.business;

import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.OrganizationDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.exception.business.FileInsertException;
import org.r.system.cs.service.business.OrganizationService;
import org.r.system.cs.util.annotation.InjectProjectId;
import org.r.system.cs.util.dto.MsgDTO;
import org.r.system.cs.util.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/busi/baseinfo/organization")
public class OrganizationController {

	@Autowired
	private OrganizationService orgService;

	/**
	 * 添加科室
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.POST })
	public MsgDTO addOrganization(@RequestBody OrganizationDTO info) {
		MsgDTO msg = null;

		if (info.getName() == null || info.getProjectId() == null)
			return new MsgDTO("400", "科室名称和项目id不能为空");

		try {
			orgService.createFile(info);
			msg = new MsgDTO("200", "创建成功");
		} catch (FileInsertException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	/**
	 * 修改科室
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.PUT })
	public MsgDTO modifyOrganization(@RequestBody OrganizationDTO info) {
		MsgDTO msg = null;

		if (info.getId() == null)
			return new MsgDTO("400", "科室id不能为空");

		try {
			orgService.updateFile(info);
			msg = new MsgDTO("200", "修改成功");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	/**
	 * 停用科室
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.DELETE })
	public MsgDTO deleteOrganization(Integer id, Boolean status) {
		MsgDTO msg = null;
		if (id == null || status == null)
			return new MsgDTO("400", "科室id和科室状态不能为空");

		try {
			orgService.disableOrg(id, status);
			msg = new MsgDTO("200", "变更状态完成");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	/**
	 * 查询科室列表
	 * 
	 * @param faId
	 * @return
	 */
	@InjectProjectId(value = SearchConditionDTO.class, propertyName = "projectId")
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public MsgDTO getOrgList(@RequestBody SearchConditionDTO dto) {

		MsgDTO msg = null;

		if (dto.getProjectId() == null)
			return new MsgDTO("400", "项目id不能为空");

		try {
			ListDTO<OrganizationDTO> result = orgService.getOrganizationList(dto);
			PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPage(), result.getSize());
			page.setResult(result.getResult());
			msg = new MsgDTO("200", page);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	/**
	 * 查询科室详细信息
	 * 
	 * @param faId
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.GET })
	public MsgDTO getOrganization(@RequestParam Integer id) {
		MsgDTO msg = null;
		if (id == null)
			return new MsgDTO("200", "科室id不能为空");
		try {
			msg = new MsgDTO("200", orgService.getFile(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

}
