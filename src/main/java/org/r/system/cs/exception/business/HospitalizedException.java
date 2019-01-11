/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.exception.business 
 * @author: Casper   
 * @date: 2018年11月8日 下午4:10:41 
 */
package org.r.system.cs.exception.business;

/**
 * @author Casper
 *
 */
public class HospitalizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1786665098617318321L;
	private String msg;

	public HospitalizedException(String msg) {
		this.msg = msg;
	}

	public HospitalizedException() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
