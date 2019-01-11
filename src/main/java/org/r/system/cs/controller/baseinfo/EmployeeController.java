package org.r.system.cs.controller.baseinfo;

import java.util.List;

import org.r.system.cs.dto.baseinfo.BehaivorDTO;
import org.r.system.cs.dto.baseinfo.EmpinfoDTO;
import org.r.system.cs.dto.baseinfo.EmployeeDTO;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
import org.r.system.cs.service.baseinfo.BehaivorService;
import org.r.system.cs.service.baseinfo.EmployeeService;
import org.r.system.cs.util.dto.MsgDTO;
import org.r.system.cs.util.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baseinfo/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private BehaivorService bservice;

	/**
	 * 添加员工资料
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.POST })
	public MsgDTO addEmployee(@RequestBody EmployeeDTO dto) {

		MsgDTO message = null;
		if (dto.getIdcard() == null || dto.getIdcard().equals("")) {
			message = new MsgDTO("400", "身份证不能为空");
			return message;
		}
		if (dto.getName() == null || dto.getName().equals("")) {
			message = new MsgDTO("400", "姓名不能为空");
			return message;
		}
		if (dto.getPhone() == null || dto.getPhone().equals("")) {
			message = new MsgDTO("400", "手机号不能为空");
			return message;
		}
		try {
			String code = service.addEmployee(dto);
			if (code != null) {
				message = new MsgDTO("200", code);
			} else {
				message = new MsgDTO("400", "添加失败");
			}

		} catch (Exception e) {
			message = new MsgDTO("400", e.getCause().getMessage());
		}
		return message;
	}

	/**
	 * 查询员工信息列表
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public MsgDTO getCondition(@RequestBody SearchConditionDTO dto) {
		PageDTO pagedto = null;
		MsgDTO message = null;

		try {
			List<EmployeeDTO> empdto = service.getCondition(dto);
			if (empdto.size() > 0) {
				pagedto = new PageDTO(dto.getPageSize(),dto.getCurPageOrg(),
						service.getListCount(dto));
				pagedto.setResult(empdto);
				message = new MsgDTO("200", pagedto);
			} else {
				message = new MsgDTO("400", "员工不存在");
			}
		} catch (Exception e) {

			message = new MsgDTO("400", e.getCause().getMessage());
		}

		return message;
	}

	/**
	 * 查询员工资料
	 * 
	 * @param code
	 * @param idcard
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.GET })
	public MsgDTO getCodeAndidCard(@RequestParam(required=false) String code, @RequestParam(required=false) String idcard) {

		MsgDTO message = null;
		try {
			EmployeeDTO dto = service.getCodeAndidCard(code, idcard);
			if (dto == null) {
				message = new MsgDTO("400", "系统异常");
			} else {
				message = new MsgDTO("200", dto);
			}

		} catch (Exception e) {
			message = new MsgDTO("400", e.getCause().getMessage());
		}
		return message;
	}

	/**
	 * 修改员工信息
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "", method = { RequestMethod.PUT })
	public MsgDTO modifyEmployee(@RequestBody EmployeeDTO dto) {
		MsgDTO message = null;

		if (dto.getCode() == null) {
			message = new MsgDTO("400", "员工编号不能为空");
			return message;
		}
		try {

			if (service.modifyEmployeeinfo(dto) > 0) {
				message = new MsgDTO("200", "修改成功");
			} else {
				message = new MsgDTO("400", "该身份证已有员工登记");
			}

		} catch (Exception e) {
			message = new MsgDTO("400", e.getCause().getMessage());
		}

		return message;
	}

	/**
	 * 添加行为记录
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/behavior", method = { RequestMethod.POST })
	public MsgDTO addBehaivor(@RequestBody BehaivorDTO dto) {

		MsgDTO message = null;
		if (dto.getDatetime() == null || dto.getDatetime().equals("")) {
			message = new MsgDTO("400", "时间不能为空");
			return message;
		}
		if (dto.getGrade() == 0) {
			message = new MsgDTO("400", "评价不能为空");
			return message;
		}
		if (dto.getEmployeeid() == null || dto.getEmployeeid().equals("")) {
			message = new MsgDTO("400", "员工记录号不能为空");
			return message;
		}
		try {
			String code = bservice.addBehaivor(dto);
			if (code != null) {
				message = new MsgDTO("200", code);
			} else {
				message = new MsgDTO("400", "添加失败");
			}

		} catch (Exception e) {
			message = new MsgDTO("400", e.getCause().getMessage());
		}
		return message;
	}

	/**
	 * 查询行为记录列表
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/behavior/list", method = { RequestMethod.POST })
	public MsgDTO getBehaivorinfo(@RequestBody EmpinfoDTO dto) {

		PageDTO pagedto = null;
		MsgDTO message = null;

		try {
			dto.setCurpage(dto.getCurpage() - 1);
			List<BehaivorDTO> empdto = bservice.getBehaivorinfo(dto);
			if (empdto.size() > 0) {
				pagedto = new PageDTO(dto.getPagesize(), dto.getCurpage() / dto.getPagesize() + 1,
						bservice.getbListCount(dto));
				pagedto.setResult(empdto);
				message = new MsgDTO("200", pagedto);
			} else {
				message = new MsgDTO("400", "记录不存在");
			}
		} catch (Exception e) {

			message = new MsgDTO("400", e.getCause().getMessage());
		}

		return message;
	}

	/**
	 * 查询员工资料
	 * 
	 * @param code
	 * @param idcard
	 * @return
	 */
	@RequestMapping(value = "/behavior", method = { RequestMethod.GET })
	public MsgDTO getCode(@RequestParam String code) {

		MsgDTO message = null;
		try {
			BehaivorDTO dto = bservice.getCode(code);
			if (dto == null) {
				message = new MsgDTO("400", "系统异常");
			} else {
				message = new MsgDTO("200", dto);
			}

		} catch (Exception e) {
			message = new MsgDTO("400", e.getCause().getMessage());
		}
		return message;
	}

}
