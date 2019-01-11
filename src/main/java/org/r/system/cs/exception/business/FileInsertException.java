/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午10:39:52 
 */
package org.r.system.cs.exception.business;

/**
 * @author Casper
 *
 */
public class FileInsertException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6040291198189356032L;

	private String msg;

	public FileInsertException(String msg) {
		this.msg = msg;
	}

	public FileInsertException() {
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
