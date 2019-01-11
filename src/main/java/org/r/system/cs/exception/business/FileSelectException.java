/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.business 
 * @author: Casper   
 * @date: 2018年11月9日 上午8:51:51 
 */
package org.r.system.cs.exception.business;

/**
 * @author Casper
 *
 */
public class FileSelectException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8658367999037135936L;

	private String msg;

	public FileSelectException() {
	}

	public FileSelectException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
