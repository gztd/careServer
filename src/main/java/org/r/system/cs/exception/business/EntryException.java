/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.business 
 * @author: Casper   
 * @date: 2018年11月12日 下午10:53:49 
 */
package org.r.system.cs.exception.business;

/**
 * @author Casper
 *
 */
public class EntryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2470742105104747192L;

	private String msg;

	public EntryException(String msg) {
		this.msg = msg;
	}

	public EntryException() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
