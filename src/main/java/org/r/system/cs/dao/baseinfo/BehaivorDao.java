package org.r.system.cs.dao.baseinfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.r.system.cs.dto.baseinfo.BehaivorDTO;
import org.r.system.cs.dto.baseinfo.EmpinfoDTO;
@Mapper
public interface BehaivorDao {
	
	/**
	 * 添加行为记录
	 * @param dto
	 * @return
	 */
	public int insertBehaivor(BehaivorDTO dto);
	
	/**
	 * 查询行为记录列表
	 * @param dto
	 * @return
	 */
	public List<BehaivorDTO> selectByBehaivorinfo(EmpinfoDTO dto);
	
	/**
	 * 查询行为记录
	 * @return
	 */
	public BehaivorDTO selectByCode(@Param("code") String code);
	
	/**
	 * 查询行为记录的总条数
	 * @param dto
	 * @return
	 */
	public int selectbListCount(EmpinfoDTO dto);

}
