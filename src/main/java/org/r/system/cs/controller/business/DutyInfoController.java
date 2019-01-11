package org.r.system.cs.controller.business;

import java.util.ArrayList;

import org.r.system.cs.dto.business.DutyDetailDTO;
import org.r.system.cs.dto.business.DutyInfoDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.service.business.DutyInfoService;
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
@RequestMapping("/api/busi/routine")
public class DutyInfoController {

	@Autowired
	private DutyInfoService dutyService;

	/**
	 * 制定值勤表
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO addDutyInfo(@RequestBody DutyInfoDTO info) {
		MsgDTO msg = null;

		if (info.getCareworkerIds() == null || info.getCareworkerIds().isEmpty() || info.getDate() == null) {
			return new MsgDTO("400", "陪护人员和日期不能为空");
		}

		try {
			dutyService.createFile(info);
			msg = new MsgDTO("200", "创建成功");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

	/**
	 * 查询陪护人员值班信息
	 * 
	 * @param ordered
	 * @param date
	 * @param orgcode
	 * @return
	 */
	@RequestMapping(value = "/list", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public MsgDTO getDutyInfoList(@RequestBody SearchConditionDTO dto) {
		MsgDTO msg = null;
		if (dto.getStartDate() == null || dto.getEndDate() == null) {
			return new MsgDTO("400", "时间区间不能为空");
		}
		try {
			ListDTO<DutyDetailDTO> target = dutyService.getDutyInfoList(dto);
			PageDTO page = new PageDTO(dto.getPageSize(), dto.getCurPage(), target.getSize());
			page.setResult(target.getResult());
			msg = new MsgDTO("200", page);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}

		return msg;
	}

	/**
	 * 签到
	 * 
	 * @param orderid
	 * @param date
	 * @param isworked
	 * @return
	 */
	@RequestMapping(value = "", produces = "application/json;charset=utf-8", method = { RequestMethod.PUT })
	public MsgDTO modifyRota(@RequestParam Long careworkerId, @RequestParam String date,
			@RequestParam Boolean isWorked) {
		MsgDTO msg = null;

		if (careworkerId == null || date == null || isWorked == null)
			return new MsgDTO("400", "陪护人员id、日期和状态不能为空");

		DutyInfoDTO info = new DutyInfoDTO();
		info.setCareworkerIds(new ArrayList<Long>());
		info.getCareworkerIds().add(careworkerId);
		info.setDate(date);
		info.setIsWorked(isWorked);
		try {
			dutyService.updateFile(info);
			msg = new MsgDTO("200", "修改成功");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			msg = new MsgDTO("400", e.getCause().getMessage());
		}
		return msg;
	}

}
