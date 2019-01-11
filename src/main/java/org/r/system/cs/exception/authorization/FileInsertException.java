/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.authorization 
 * @author: Casper   
 * @date: 2018年11月5日 下午2:37:21 
 */
package org.r.system.cs.exception.authorization;

/**
 * @author Casper
 *
 */
public class FileInsertException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5629228302712373980L;
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

}
