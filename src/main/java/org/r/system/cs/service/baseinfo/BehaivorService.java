package org.r.system.cs.service.baseinfo;

import java.util.List;

import org.r.system.cs.dto.baseinfo.BehaivorDTO;
import org.r.system.cs.dto.baseinfo.EmpinfoDTO;

public interface BehaivorService {

	/**
	 * 添加行为记录
	 * 
	 * @param dto
	 * @return
	 */
	public String addBehaivor(BehaivorDTO dto);

	/**
	 * 查询行为记录列表
	 * 
	 * @param dto
	 * @return
	 */
	public List<BehaivorDTO> getBehaivorinfo(EmpinfoDTO dto);

	/**
	 * 查询行为记录
	 * 
	 * @return
	 */
	public BehaivorDTO getCode(String code);

	/**
	 * 查询行为记录的总条数
	 * 
	 * @param dto
	 * @return
	 */
	public int getbListCount(EmpinfoDTO dto);

}
