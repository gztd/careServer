package org.r.system.cs.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.r.system.cs.dto.business.MissionDetailInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;

@Mapper
public interface MissionDao extends BaseDao {

	/**
	 * 根据查询条件查询任务单列表
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午5:31:41
	 * @param dto
	 * @return
	 */
	public List<MissionDetailInfoDTO> selectMissionList(SearchConditionDTO dto);

	/**
	 * 根据条件查询任务单的详细信息
	 * 
	 * @author Casper
	 * @date 2018年11月13日 下午3:36:53
	 * @param dto
	 * @return
	 */
	public List<MissionDetailInfoDTO> selectMissionDetailList(SearchConditionDTO dto);

}
