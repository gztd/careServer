/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.business 
 * @author: Casper   
 * @date: 2018年11月12日 上午11:20:28 
 */
package org.r.system.cs.exception.business;

/**
 * @author Casper
 *
 */
public class FileDeleteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2791590217441293685L;
	private String msg;

	public FileDeleteException(String msg) {
		this.msg = msg;
	}

	public FileDeleteException() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "FileInsertException [msg=" + msg + "]";
	}
}
