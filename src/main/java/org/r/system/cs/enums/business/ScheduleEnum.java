/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.enums.business 
 * @author: Casper   
 * @date: 2018年11月12日 上午1:51:34 
 */
package org.r.system.cs.enums.business;

/**
 * @author Casper
 *
 */
public enum ScheduleEnum {
	
	day("白班",1), night("夜班",2){
	};
	private int value;
	private String name;

	private ScheduleEnum(String name,int value) {
		this.value = value;
		this.name = name;
	}
	
	public static String getSate(int index) {
		for(ScheduleEnum s : ScheduleEnum.values()) {
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
