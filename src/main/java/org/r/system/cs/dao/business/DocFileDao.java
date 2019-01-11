package org.r.system.cs.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.DocFileEntity;

@Mapper
public interface DocFileDao extends BaseDao {

	/**
	 * 按条件查询档案列表
	 * 
	 * @author Casper
	 * @date 2018年11月12日 下午1:04:51
	 * @param dto
	 * @return
	 */
	public List<DocFileEntity> selectFileList(SearchConditionDTO dto);
}
