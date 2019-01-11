package org.r.system.cs.service.business;

import org.r.system.cs.dto.business.DocFileDTO;
import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;

public interface DocFileService extends BaseService {

	/**
	 * 按条件查询单据列表
	 * 
	 * @author Casper
	 * @date 2018年11月12日 下午1:46:20
	 * @param dto
	 * @return
	 */
	public ListDTO<DocFileDTO> getDocFileList(SearchConditionDTO dto);

}
