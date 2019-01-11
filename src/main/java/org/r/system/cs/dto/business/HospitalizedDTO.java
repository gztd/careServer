/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:44:20 
 */
package org.r.system.cs.dto.business;

import org.r.system.cs.dto.baseinfo.PatientInfoDTO;
import org.r.system.cs.dto.baseinfo.TransactionInfoDTO;

/**
 * @author Casper
 *
 */
public class HospitalizedDTO {

	// 住院服务单信息
	private OrderInfoDTO hospitalizedInfo;
	// 请求单信息
	private RequestInfoDTO serviceInfo;
	// 病人信息
	private PatientInfoDTO patient;
	// 交易信息
	private TransactionInfoDTO transactionRecord;
	// 项目id
	private Integer projectId;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public OrderInfoDTO getHospitalizedInfo() {
		hospitalizedInfo.setName(this.patient.getName());
		hospitalizedInfo.setPatientCode(this.patient.getCode());
		hospitalizedInfo.setPhone(this.patient.getPhone());

		return hospitalizedInfo;
	}

	public void setHospitalizedInfo(OrderInfoDTO hospitalizedInfo) {
		this.hospitalizedInfo = hospitalizedInfo;
	}

	public RequestInfoDTO getServiceInfo() {
		serviceInfo.setClerk(this.getHospitalizedInfo().getClerk());

		return serviceInfo;
	}

	public void setServiceInfo(RequestInfoDTO serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public PatientInfoDTO getPatient() {
		return patient;
	}

	public void setPatient(PatientInfoDTO patient) {
		this.patient = patient;
	}

	public TransactionInfoDTO getTransactionRecord() {
		return transactionRecord;
	}

	public void setTransactionRecord(TransactionInfoDTO transactionRecord) {
		this.transactionRecord = transactionRecord;
	}

	@Override
	public String toString() {
		return "HospitalizedDTO [hospitalizedInfo=" + hospitalizedInfo + ", serviceInfo=" + serviceInfo + ", patient="
				+ patient + ", transactionRecord=" + transactionRecord + "]";
	}

}
