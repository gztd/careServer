/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.util 
 * @author: Casper   
 * @date: 2018年10月31日 下午8:11:48 
 */
package org.r.system.cs.util.dto;

/**
 * @author Casper
 *
 */
public class MsgDTO {

	private String code;
	private Object msg;

	public MsgDTO(String code, Object msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public MsgDTO() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MsgDTO [code=" + code + ", msg=" + msg + "]";
	}

}
