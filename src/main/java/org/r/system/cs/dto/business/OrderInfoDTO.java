/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月8日 上午10:37:32 
 */
package org.r.system.cs.dto.business;

import java.text.ParseException;

import org.r.system.cs.entity.business.OrderEntity;
import org.r.system.cs.util.tool.UtilTool;

/**
 * @author Casper
 *
 */
public class OrderInfoDTO extends OrderEntity {

	// 入院时间
	private String hospitalizedTime;
	// 出院时间
	private String leaveTime;

	public String getHospitalizedTime() {
		return hospitalizedTime;
	}

	public void setHospitalizedTime(String hospitalizedTime) {
		this.hospitalizedTime = hospitalizedTime;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	

	@Override
	public String toString() {
		return "OrderInfoDTO [hospitalizedTime=" + hospitalizedTime + ", leaveTime=" + leaveTime + "]";
	}
	
	public OrderEntity build() throws ParseException {
		OrderEntity order = this;
		order.setCode("OR"+System.currentTimeMillis());
		order.setHospitalizedDate(UtilTool.getTimestampByDateTimeString(this.getHospitalizedTime()));
		if(this.leaveTime != null) {
			order.setLeaveDate(UtilTool.getTimestampByDateTimeString(leaveTime));
		}
		return order;
	}

	public OrderInfoDTO() {
	}

	public OrderInfoDTO(OrderEntity order) {
		this.balance = order.getBalance();
		this.clerk = order.getClerk();
		this.code = order.getCode();
		this.hospitalizedTime = order.getHospitalizedDate().toString();
		this.id = order.getId();
		this.leaveTime = order.getLeaveDate() == null?null:order.getLeaveDate().toString();
		this.name = order.getName();
		this.patientCode = order.getPatientCode();
		this.phone = order.getPhone();
	}

	
	
	
}
