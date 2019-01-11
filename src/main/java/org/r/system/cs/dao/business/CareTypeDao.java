package org.r.system.cs.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.CareTypeEntity;

@Mapper
public interface CareTypeDao extends BaseDao {

	/**
	 * 删除档案记录
	 * 
	 * @author Casper
	 * @date 2018年11月12日 上午11:16:14
	 * @param primaryKey
	 * @return
	 */
	public int deleteFile(Object primaryKey);

	/**
	 * 按条件查询陪护类型档案
	 * 
	 * @author Casper
	 * @date 2018年11月12日 上午11:54:20
	 * @param dto
	 * @return
	 */
	public List<CareTypeEntity> selectFileList(SearchConditionDTO dto);

}
