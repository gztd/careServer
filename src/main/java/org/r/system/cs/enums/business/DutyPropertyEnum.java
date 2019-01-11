/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.enums.business 
 * @author: Casper   
 * @date: 2018年11月13日 上午9:50:40 
 */
package org.r.system.cs.enums.business;

/**
 * @author Casper
 *
 */
public enum DutyPropertyEnum {
	
	normal("正常考勤",1), OT("加班",2), leave("请假",3) {
	};
	private int value;
	private String name;

	private DutyPropertyEnum(String name,int value) {
		this.value = value;
		this.name = name;
	}
	
	public static String getSate(int index) {
		for(DutyPropertyEnum s : DutyPropertyEnum.values()) {
			if(s.getIndex() == index) return s.getName();
		}
		return null;
	}
	public int getIndex() {
		return value;
	}
	public String getName() {
		return name;
	}
}
