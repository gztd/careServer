/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.dto 
 * @author: Casper   
 * @date: 2018年10月26日 下午6:10:03 
 */
package org.r.system.cs.dto.baseinfo;

/**
 * @author Casper
 *
 */
public class PatientInfoDTO {

	// 病人编号
	private String code;
	// 病人姓名
	private String name;
	// 病人联系方式
	private String phone;
	// 病人身份证
	private String idCard;
	// 病人性别
	private Integer sex = 0;
	// 病人联系地址
	private String address;
	// 病人联系人
	private String linkman;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
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

	@Override
	public String toString() {
		return "PatientInfoDTO [code=" + code + ", name=" + name + ", phone=" + phone + ", idCard=" + idCard + ", sex="
				+ sex + ", address=" + address + ", linkman=" + linkman + "]";
	}

}
