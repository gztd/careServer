package org.r.system.cs.service.business;

import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.MissionDetailInfoDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;

public interface MissionService extends BaseService {

	/**
	 * 查询派遣历史列表
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午5:39:59
	 * @param dto
	 * @return
	 */
	public ListDTO<MissionDetailInfoDTO> getMissionList(SearchConditionDTO dto);

	/**
	 * 获取任务详细信息
	 * 
	 * @author Casper
	 * @date 2018年11月13日 下午2:35:16
	 * @param dto
	 * @return
	 */
	public ListDTO<MissionDetailInfoDTO> getMissionDetail(SearchConditionDTO dto);
	
	/**
	 * 结束任务
	 * @author Casper
	 * @date 2018年11月13日 下午4:28:38
	 * @param requestCode
	 */
	public void closeMission(String requestCode, String date);

}
