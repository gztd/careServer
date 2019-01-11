/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.exception 
 * @author: Casper   
 * @date: 2018年10月29日 下午5:57:54 
 */
package org.r.system.cs.exception.baseinfo;

/**
 * @author Casper
 *
 */
public class PatientNotFoundException extends RuntimeException {

	private String msg;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3002472820413594443L;

	public PatientNotFoundException() {
		super();
	}

	public PatientNotFoundException(String arg0) {
		this.msg = arg0;
	}

	public String getMsg() {
		return msg;
	}

}
