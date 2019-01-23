/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dao.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午3:59:51 
 */
package org.r.system.cs.dao.report;



/**
 * @author Casper
 *
 */
public interface BaseDao {

	/**
	 * 查询一条记录
	 * 
	 * @author Casper
	 * @date 2018年11月7日 下午4:05:05
	 * @param primaryKey
	 * @return
	 */
	public Object selectFile(Object primaryKey);


}
