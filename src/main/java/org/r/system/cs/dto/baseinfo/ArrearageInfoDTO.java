/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.dto 
 * @author: Casper   
 * @date: 2018年10月27日 上午11:06:07 
 */
package org.r.system.cs.dto.baseinfo;

/**
 * @author Casper
 *
 */
public class ArrearageInfoDTO {

	// 日期
	private String date;
	// 欠费金额
	private Double money;
	// 医院科室名称
	private String hospitalName;
	// 服务单编号
	private String hospitalCode;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
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

	@Override
	public String toString() {
		return "ArrearageInfoDTO [date=" + date + ", money=" + money + ", hospitalName=" + hospitalName
				+ ", hospitalCode=" + hospitalCode + "]";
	}

}
