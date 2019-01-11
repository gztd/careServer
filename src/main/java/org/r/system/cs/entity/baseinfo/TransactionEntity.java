/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.entity 
 * @author: Casper   
 * @date: 2018年10月29日 下午6:46:18 
 */
package org.r.system.cs.entity.baseinfo;

import java.sql.Timestamp;

/**
 * @author Casper
 *
 */
public class TransactionEntity {

	// 交易编号
	private String code;
	// 交易金额
	private Double money;
	// 日期时间
	private Timestamp dateTime;
	// 病人记录号
	private Long patientId;
	// 付款人姓名
	private String payMan;
	// 交易类型
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

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

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getDateTime() {
		return dateTime.toString();
	}

	public Timestamp getDateTimeStamp() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "TransactionEntity [code=" + code + ", money=" + money + ", dateTime=" + dateTime + ", patientId="
				+ patientId + ", payMan=" + payMan + ", type=" + type + "]";
	}

}
