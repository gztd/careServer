package org.r.system.cs.dao.baseinfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.r.system.cs.dto.baseinfo.EmployeeDTO;
import org.r.system.cs.dto.baseinfo.SearchConditionDTO;
@Mapper
public interface EmployeeDao {
	/**
	 * 添加员工的信息
	 * @param dto
	 * @return
	 */
	public int insertEmployee(EmployeeDTO dto);
	/**
	 * 根据id查询员工编号
	 * @param id
	 * @return
	 */
    public EmployeeDTO selectByid(int id);
    /**
	 * 查询员工列表
	 * @param id
	 * @return
	 */
    public List<EmployeeDTO> selectByCondition(SearchConditionDTO dto);
    /**
	 * 查询员工资料
	 * @param id
	 * @return
	 */
    public EmployeeDTO selectByCodeAndidCard(@Param("code") String code, @Param("idcard") String idcard);
    
    
    /**
     * 修改员工信息
     * @param dto
     * @return
     */
    public int updataEmployeeinfo(EmployeeDTO dto);
    
    /**
     * 查询员工列表总条数
     * @param dto
     * @return
     */
    public int selectListCount(SearchConditionDTO dto);
    

}
