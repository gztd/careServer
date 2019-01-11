package org.r.system.cs.enums.business;

public enum PropertyEnum {
      
	onetoone("一对一",1), onetomany("一对多",2), manytomany("多对多",3) {
	};
	private int value;
	private String name;

	private PropertyEnum(String name,int value) {
		this.value = value;
		this.name = name;
	}
	
	public static String getSate(int index) {
		for(PropertyEnum s : PropertyEnum.values()) {
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
