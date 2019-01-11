/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.dto 
 * @author: Casper   
 * @date: 2018年10月27日 上午10:13:30 
 */
package org.r.system.cs.dto.baseinfo;

/**
 * @author Casper
 *
 */
public class TransactionInfoDTO {

	// 病人编号
	private String code;
	// 交易类型
	private Integer type;
	// 交易金额
	private Double money;
	// 交易日期
	private String date;
	// 医院科室名称
	private String hospitalName;
	// 住院单编号
	private String hospitalCode;
	// 项目编号
	private Integer projectId;
	// 付款人姓名
	private String payMan;

	public String getPayMan() {
		return payMan;
	}

	public void setPayMan(String payMan) {
		this.payMan = payMan;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "TransactionInfoDTO [code=" + code + ", type=" + type + ", money=" + money + ", date=" + date
				+ ", hospitalName=" + hospitalName + ", hospitalCode=" + hospitalCode + ", projectId=" + projectId
				+ ", payMan=" + payMan + "]";
	}


}
