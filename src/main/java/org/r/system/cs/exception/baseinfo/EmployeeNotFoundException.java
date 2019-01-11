/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.baseinfo 
 * @author: Casper   
 * @date: 2018年11月3日 上午10:26:46 
 */
package org.r.system.cs.exception.baseinfo;

/**
 * @author Casper
 *
 */
public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1889973392331889640L;

	private String msg;

	public EmployeeNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public EmployeeNotFoundException() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
