package org.r.system.cs.service.baseinfo;

import java.util.List;

import org.r.system.cs.dto.baseinfo.EmployeeDTO;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;

public interface EmployeeService {
	
	/**
	 * 添加员工的信息
	 * @param dto
	 * @return
	 */
	public String addEmployee(EmployeeDTO dto);
	/**
	 * 查询员工列表
	 * @param id
	 * @return
	 */
	public List<EmployeeDTO> getCondition(SearchConditionDTO dto);
    /**
	 * 查询员工资料
	 *@param id
	 * @return
	 */
	public EmployeeDTO getCodeAndidCard(String code, String idcard);
	/**
     * 修改员工信息
     * @param dto
     * @return
     */
	public int modifyEmployeeinfo(EmployeeDTO dto);
	
	
	 /**
     * 查询员工列表总条数
     * @param dto
     * @return
     */
    public int getListCount(SearchConditionDTO dto);

}
