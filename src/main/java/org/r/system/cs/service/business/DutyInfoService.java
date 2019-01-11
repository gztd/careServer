package org.r.system.cs.service.business;

import org.r.system.cs.dto.business.DutyDetailDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;

public interface DutyInfoService extends BaseService {

	/**
	 * 根据搜索条件搜索陪护人员的值班信息
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午10:20:33
	 * @param dto
	 *            搜索条件
	 * @return
	 */
	public ListDTO<DutyDetailDTO> getDutyInfoList(SearchConditionDTO dto);

}
