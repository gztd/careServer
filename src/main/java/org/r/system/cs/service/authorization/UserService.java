/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.service.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午7:49:40 
 */
package org.r.system.cs.service.authorization;

/**
 * @author Casper
 *
 */
public interface UserService extends BaseService{

	/**
	 * 锁上/解锁一个用户,lock=true:锁上用户,lock=false:解锁用户
	 * 
	 * @author Casper
	 * @date 2018年10月31日 下午10:47:46
	 * @param username
	 * @param lock
	 * @return 操作成功返回true，否则false
	 */
	public boolean lockUser(String username, boolean lock);
	
}
