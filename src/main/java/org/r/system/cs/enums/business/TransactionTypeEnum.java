/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.enums.business 
 * @author: Casper   
 * @date: 2018年11月9日 下午10:48:07 
 */
package org.r.system.cs.enums.business;

/**
 * @author Casper
 *
 */
public enum TransactionTypeEnum {
	
	renew("充值/续费",1), settle("结算",2),refund("退款",3){
	};
	private int value;
	private String name;

	private TransactionTypeEnum(String name,int value) {
		this.value = value;
		this.name = name;
	}
	
	public static String getSate(int index) {
		for(TransactionTypeEnum s : TransactionTypeEnum.values()) {
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
