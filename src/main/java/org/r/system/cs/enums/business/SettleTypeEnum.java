package org.r.system.cs.enums.business;

public enum SettleTypeEnum {
    
	dayindex("日",1), cases("例",2){
	};
	private int value;
	private String name;

	private SettleTypeEnum(String name,int value) {
		this.value = value;
		this.name = name;
	}
	
	public static String getSate(int index) {
		for(SettleTypeEnum s : SettleTypeEnum.values()) {
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
