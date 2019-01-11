package org.r.system.cs.serviceimpl.baseinfo;

import java.util.List;

import org.r.system.cs.dao.baseinfo.EmployeeDao;
import org.r.system.cs.dto.baseinfo.EmployeeDTO;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
import org.r.system.cs.exception.baseinfo.EmployeeNotFoundException;
import org.r.system.cs.service.baseinfo.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeSerivceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	/**
	 * 添加员工资料
	 */
	@Override
	@Transactional
	public String addEmployee(EmployeeDTO dto) {

		dto.setCode("EM" + System.currentTimeMillis());
		dao.insertEmployee(dto);
		return dto.getCode();
	}

	/**
	 * 查询员工列表
	 */
	@Override
	public List<EmployeeDTO> getCondition(SearchConditionDTO dto) {

		return dao.selectByCondition(dto);
	}

	/**
	 * 查询员工资料
	 */
	@Override
	public EmployeeDTO getCodeAndidCard(String code, String idcard) {

		return dao.selectByCodeAndidCard(code, idcard);

	}

	/**
	 * 修改员工信息
	 */
	@Override
	@Transactional
	public int modifyEmployeeinfo(EmployeeDTO dto) {

		EmployeeDTO empdto = dao.selectByCodeAndidCard(dto.getCode(), null);
		if (empdto.getCode() == null)
			throw new EmployeeNotFoundException("员工不存在");
	
		return dao.updataEmployeeinfo(dto);
	}
    /**
     * 查询员工总条数
     */
	@Override
	public int getListCount(SearchConditionDTO dto) {
		
		return dao.selectListCount(dto);
	}

}
