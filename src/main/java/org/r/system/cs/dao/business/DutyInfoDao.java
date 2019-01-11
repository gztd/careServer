package org.r.system.cs.dao.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.DutyInfoEntity;

@Mapper
public interface DutyInfoDao extends BaseDao {


	/**
	 * 根据查询条件搜索陪护人员的值班信息
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午10:24:12
	 * @param dto
	 * @return
	 */
	public List<Map<String, Object>> selectDutyInfoDetail(SearchConditionDTO dto);
	
	/**
	 * @author Casper
	 * @date 2018年11月18日 下午1:17:50
	 * @param file
	 * @return
	 */
	public int deleteFile(DutyInfoEntity file);

}
