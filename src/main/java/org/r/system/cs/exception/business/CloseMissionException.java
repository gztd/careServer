/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.business 
 * @author: Casper   
 * @date: 2018年11月13日 下午4:33:44 
 */
package org.r.system.cs.exception.business;

/**
 * @author Casper
 *
 */
public class CloseMissionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7471861088440405521L;
	private String msg;

	public CloseMissionException(String msg) {
		this.msg = msg;
	}

	public CloseMissionException() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
