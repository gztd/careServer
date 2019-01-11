package org.r.system.cs.controller.business;

import org.r.system.cs.dto.business.CareTypeInfoDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.exception.business.FileDeleteException;
import org.r.system.cs.exception.business.FileInsertException;
import org.r.system.cs.service.business.CareTypeService;
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
@RequestMapping("/api/busi/baseinfo/caretype")
public class CaretypeController {

	@Autowired
	private CareTypeService careTypeService;

	@InjectProjectId(value = CareTypeInfoDTO.class,propertyName = "projectId")
	@RequestMapping(value = "", method = { RequestMethod.POST })
	public MsgDTO addCaretype(@RequestBody CareTypeInfoDTO info) {
		MsgDTO msg = null;
		if (info.getName() == null || info.getPrice() == null || info.getProjectId() == null
				|| info.getSalaryIndex() == null) {
			return new MsgDTO("400", "陪护类型名称、价格、项目id和工资计算系数不能为空");
		}

		try {
			careTypeService.createFile(info);
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
	 * 修改陪护类型
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.PUT })
	public MsgDTO modifyCaretype(@RequestBody CareTypeInfoDTO info) {
		MsgDTO msg = null;
		if (info.getName() == null || info.getPrice() == null || info.getProjectId() == null
				|| info.getSalaryIndex() == null) {
			return new MsgDTO("400", "陪护类型名称、价格、项目id和工资计算系数不能为空");
		}

		try {
			careTypeService.updateFile(info);
			msg = new MsgDTO("200", "修改完成");
		} catch (FileDeleteException e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getMsg());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	/**
	 * 查询陪护列表
	 * 
	 * @param info
	 * @return
	 */
	@InjectProjectId(value=SearchConditionDTO.class,propertyName = "projectId")
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public MsgDTO getCaretypelist(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;

		try {
			ListDTO<CareTypeInfoDTO> result = careTypeService.getFileList(dto);
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
	 * 查询陪护类型详细信息
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.GET })
	public MsgDTO getCaretype(@RequestParam Integer id) {
		MsgDTO msg = null;

		if (id == null)
			return new MsgDTO("400", "陪护类型id不能为空");

		try {
			msg = new MsgDTO("200", careTypeService.getFile(id));

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

}
