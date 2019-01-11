/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.entity 
 * @author: Casper   
 * @date: 2018年10月26日 下午5:56:45 
 */
package org.r.system.cs.entity.baseinfo;

/**
 * @author Casper
 *
 */
public class PatientEntity {

	//记录号
	private Long id;
	//病人编号
	private String code;
	//病人身份证
	private String idCard;
	//病人姓名
	private String name;
	//病人性别
	private Integer sex = 0;
	//病人余额
	private Double balance;
	//病人联系地址
	private String address;
	//病人联系方式
	private String phone;
	//病人联系人
	private String linkman;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", code=" + code + ", idCard=" + idCard + ", name=" + name + ", sex=" + sex
				+ ", balance=" + balance + ", address=" + address + ", phone=" + phone + ", linkman=" + linkman + "]";
	}

}
