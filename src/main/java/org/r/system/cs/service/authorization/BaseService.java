/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.service.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午11:03:56 
 */
package org.r.system.cs.service.authorization;

import java.util.Map;

import org.r.system.cs.dto.authorization.SearchConditionDTO;


/**
 * @author Casper
 *
 */
public interface BaseService {

	/**
	 * 创建一个档案资料
	 * 
	 * @author Casper
	 * @date 2018年10月31日 下午11:13:05
	 * @param info
	 * @return 创建成功返回true，失败返回false
	 */
	public boolean createFile(Object info);

	/**
	 * 更新一个档案资料
	 * 
	 * @author Casper
	 * @date 2018年10月31日 下午11:13:28
	 * @param info
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean modifyFile(Object info);

	/**
	 * 获取档案列表 返回结果的结构： { size:xxx, result:{object} }
	 * 
	 * @author Casper
	 * @date 2018年10月31日 下午11:14:26
	 * @param dto
	 * @return 一页的列表和总条目数
	 */
	public Map<String, Object> getFileList(SearchConditionDTO dto);

	/**
	 * 获取一个详细档案资料
	 * 
	 * @author Casper
	 * @date 2018年10月31日 下午11:15:30
	 * @param primaryKey
	 * @return 档案资料
	 */
	public Object getFile(Object primaryKey);

	/**
	 * 禁用/解禁一个档案,disable=true:禁用档案,disable=false:解禁档案
	 * 
	 * @author Casper
	 * @date 2018年10月31日 下午11:16:01
	 * @param primaryKey
	 * @param disable
	 * @return 操作成功返回true，否则false
	 */
	public boolean disableFile(Object primaryKey, boolean disable);

}
