/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.entity 
 * @author: Casper   
 * @date: 2018年10月29日 下午7:08:12 
 */
package org.r.system.cs.entity.baseinfo;

import java.sql.Timestamp;

/**
 * @author Casper
 *
 */
public class ArrearageEntity {

	// 日期
	private Timestamp date;
	// 服务单据号
	private String recordCode;
	// 项目编号
	private Integer projectId;
	// 病人编号
	private Long patientId;
	// 医院科室名
	private String hospitalName;
	// 欠费金额
	private Double money;

	public String getDate() {
		return date.toString();
	}

	public Timestamp getDateTimestamp() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "ArrearageEntity [date=" + date + ", recordCode=" + recordCode + ", projectId=" + projectId
				+ ", patientId=" + patientId + ", hospitalName=" + hospitalName + ", money=" + money + "]";
	}

}
