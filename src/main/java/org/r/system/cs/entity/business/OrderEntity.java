/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.entity.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:40:28 
 */
package org.r.system.cs.entity.business;

import java.sql.Timestamp;

/**
 * @author Casper
 *
 */
public class OrderEntity {

	// 记录号id
	protected Long id;
	// 服务单编号
	protected String code;
	// 病人编号
	protected String patientCode;
	// 病人姓名
	protected String name;
	// 入院时间
	protected Timestamp hospitalizedDate;
	// 出院时间
	protected Timestamp leaveDate;
	// 经手人
	protected String clerk;
	// 月娥
	protected Double balance;
	// 项目id
	protected Integer projectId;
	// 联系方式
	protected String phone;

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

	public String getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getHospitalizedDate() {
		return hospitalizedDate;
	}

	public void setHospitalizedDate(Timestamp hospitalizedDate) {
		this.hospitalizedDate = hospitalizedDate;
	}
	
	public Timestamp getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Timestamp leaveDate) {
		this.leaveDate = leaveDate;
	}

	
	
	
	public String getClerk() {
		return clerk;
	}

	public void setClerk(String clerk) {
		this.clerk = clerk;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "OrderEntity [code=" + code + ", patientCode=" + patientCode + ", name=" + name + ", hospitalizedDate="
				+ hospitalizedDate + ", leaveDate=" + leaveDate + ", clerk=" + clerk + ", balance=" + balance
				+ ", projectId=" + projectId + ", phone=" + phone + "]";
	}

}
