/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.business 
 * @author: Casper   
 * @date: 2018年11月11日 下午2:01:30 
 */
package org.r.system.cs.service.business;

import org.r.system.cs.dto.business.ListDTO;
import org.r.system.cs.dto.business.SearchConditionDTO;
import org.r.system.cs.entity.business.JoinEntity;

/**
 * @author Casper
 *
 */
public interface JoinService extends BaseService {

	/**
	 * 获取陪护人员与科室的关系档案列表
	 * 
	 * @author Casper
	 * @date 2018年11月11日 下午2:09:38
	 * @param dto
	 * @return
	 */
	public ListDTO<JoinEntity> getFileList(SearchConditionDTO dto);
	
	
	/**
	 * 获取陪护人员最新的入职记录
	 * @author Casper
	 * @date 2018年11月11日 下午2:16:53
	 * @param careworkerId
	 * @return
	 */
	public JoinEntity getNewlyJoin(Long careworkerId);

}
