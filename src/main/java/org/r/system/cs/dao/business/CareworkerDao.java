package org.r.system.cs.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.business.CareworkerInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;

@Mapper
public interface CareworkerDao extends BaseDao {


	/**
	 * 按照搜索条件查询陪护人员简要信息
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午2:51:30
	 * @param dto
	 * @return
	 */
	public List<CareworkerInfoDTO> selectCareworkerInfo(SearchConditionDTO dto);

}
