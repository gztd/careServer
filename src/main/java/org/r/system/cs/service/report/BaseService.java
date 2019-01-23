/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午3:51:33 
 */
package org.r.system.cs.service.report;

import org.r.system.cs.dto.report.SearchConditionDTO;

import java.util.Map;


/**
 * @author Casper
 *
 */
public interface BaseService {

	/**
	 * 获取file信息
	 * @author Casper
	 * @date 2018年11月7日 下午3:54:49
	 * @param primaryKey
	 * @return
	 */
	public Object getFile(Object primaryKey);
	
	/**
	 * 获取file列表
	 * @author Casper
	 * @date 2018年11月7日 下午3:56:13
	 * @return
	 */
	public Map<String, Object> getFileList(SearchConditionDTO dto);
	
}
