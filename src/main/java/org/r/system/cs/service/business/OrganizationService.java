package org.r.system.cs.service.business;

import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.OrganizationDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;

public interface OrganizationService extends BaseService {

	/**
	 * 根据查询条件查询科室列表
	 * 
	 * @author Casper
	 * @date 2018年11月12日 下午2:58:36
	 * @param dto
	 * @return
	 */
	public ListDTO<OrganizationDTO> getOrganizationList(SearchConditionDTO dto);

	/**
	 * 禁用/解禁科室
	 * 
	 * @author Casper
	 * @date 2018年11月12日 下午3:01:14
	 * @param id
	 * @param status
	 */
	public void disableOrg(Integer id, Boolean status);

}
