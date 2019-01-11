package org.r.system.cs.service.business;

import org.r.system.cs.dto.business.CareTypeInfoDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;

public interface CareTypeService extends BaseService {

	/**
	 * 按照搜索条件查询陪护类型列表
	 * 
	 * @author Casper
	 * @date 2018年11月12日 上午11:52:38
	 * @param dto
	 * @return
	 */
	public ListDTO<CareTypeInfoDTO> getFileList(SearchConditionDTO dto);
}
