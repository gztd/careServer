/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.dto 
 * @author: Casper   
 * @date: 2018年10月27日 上午10:02:43 
 */
package org.r.system.cs.dto.baseinfo;

/**
 * @author Casper
 *
 */
public class PatientDetailDTO {

	// 病人编号
	private String code;
	// 病人姓名
	private String name;
	// 病人身份证
	private String idCard;
	// 病人性别
	private String sex;
	// 病人联系方式
	private String contact;
	// 病人联系地址
	private String address;
	// 病人联系人
	private String linkman;
	// 病人余额
	private String balance;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "PatientDetailDTO [code=" + code + ", name=" + name + ", idCard=" + idCard + ", sex=" + sex
				+ ", contact=" + contact + ", address=" + address + ", linkman=" + linkman + ", balance=" + balance
				+ "]";
	}

}
