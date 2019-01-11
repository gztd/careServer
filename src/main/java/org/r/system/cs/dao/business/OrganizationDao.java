package org.r.system.cs.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.OrganizationEntity;

@Mapper
public interface OrganizationDao extends BaseDao {


	/**
	 * 按照条件查询科室列表
	 * 
	 * @author Casper
	 * @date 2018年11月12日 下午2:44:54
	 * @param dto
	 * @return
	 */
	public List<OrganizationEntity> selectFileList(SearchConditionDTO dto);
	
}
