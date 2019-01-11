/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.service.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午3:51:33 
 */
package org.r.system.cs.service.business;

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
	 * 创建file记录
	 * @author Casper
	 * @date 2018年11月7日 下午3:56:06
	 * @param dto
	 */
	public Object createFile(Object dto);
	
	/**
	 * 更新file记录
	 * @author Casper
	 * @date 2018年11月7日 下午3:56:10
	 * @param dto
	 */
	public void updateFile(Object dto);
	
}
