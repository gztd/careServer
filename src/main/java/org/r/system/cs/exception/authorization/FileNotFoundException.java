/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.authorization 
 * @author: Casper   
 * @date: 2018年11月5日 上午9:21:25 
 */
package org.r.system.cs.exception.authorization;

/**
 * @author Casper
 *
 */
public class FileNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3161324435872052801L;

	private String msg;

	public FileNotFoundException(String msg) {
		this.msg = msg;
	}

	public FileNotFoundException() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
