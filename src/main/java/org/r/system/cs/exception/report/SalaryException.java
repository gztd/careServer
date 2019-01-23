/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午5:10:16 
 */
package org.r.system.cs.exception.report;

/**
 * @author Casper
 *
 */
public class SalaryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5022976828338147068L;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public SalaryException(String msg) {
		this.msg = msg;
	}

	public SalaryException() {
	}

}
