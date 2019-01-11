/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.business 
 * @author: Casper   
 * @date: 2018年11月8日 下午9:53:57 
 */
package org.r.system.cs.exception.business;

/**
 * @author Casper
 *
 */
public class LeaveException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6682409445052962410L;

	private String msg;

	public LeaveException(String msg) {
		this.msg = msg;
	}

	public LeaveException() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
