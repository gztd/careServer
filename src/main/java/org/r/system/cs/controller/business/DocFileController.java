package org.r.system.cs.controller.business;

import org.r.system.cs.dto.business.DocFileDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.service.business.DocFileService;
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
@RequestMapping("/api/busi/baseinfo/docfile")
public class DocFileController {

	@Autowired
	private DocFileService docFileService;

	/**
	 * 添加单据号
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.POST })
	public MsgDTO addDocfile(@RequestBody DocFileDTO info) {
		MsgDTO msg = null;
		if (info.getStartCode() == null || info.getEndCode() == null || info.getProjectId() == null
				|| info.getName() == null) {
			return new MsgDTO("400", "开始编号、结束编号、名称和项目id不能为空");
		}

		try {
			docFileService.createFile(info);
			msg = new MsgDTO("200", "创建成功");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	/**
	 * 修改单据号
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.PUT })
	public MsgDTO modifyDocfile(@RequestBody DocFileDTO info) {
		MsgDTO msg = null;

		if (info.getStartCode() == null || info.getEndCode() == null || info.getName() == null) {
			return new MsgDTO("400", "开始编号、结束编号、名称不能为空");
		}
		try {
			docFileService.updateFile(info);
			msg = new MsgDTO("200", "修改完成");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	/**
	 * 查询单据列表
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public MsgDTO getDocfilelist(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;

		try {
			ListDTO<DocFileDTO> result = docFileService.getDocFileList(dto);
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
	 * 查询单据详细信息
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.GET })
	public MsgDTO getCaretypelist(@RequestParam Integer id) {
		MsgDTO msg = null;
		if (id == null)
			return new MsgDTO("400", "单据id不能为空");

		try {
			msg = new MsgDTO("200", docFileService.getFile(id));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

}
