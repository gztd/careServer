/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.entity.business 
 * @author: Casper   
 * @date: 2018年11月7日 下午4:40:58 
 */
package org.r.system.cs.entity.report;

import java.sql.Timestamp;

/**
 * @author Casper
 *
 */
public class RequestEntity {

	// 请求单编号
	protected String code;
	// 服务单id
	protected Long orderId;
	// 陪护类型id
	protected Integer careTypeId;
	// 服务开始时间
	private Timestamp startDateTime;
	// 服务结束时间
	private Timestamp endDateTime;
	// 床位
	protected String bedNum;
	// 经手人
	protected String clerk;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getCareTypeId() {
		return careTypeId;
	}

	public void setCareTypeId(Integer careTypeId) {
		this.careTypeId = careTypeId;
	}

	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getBedNum() {
		return bedNum;
	}

	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}

	public String getClerk() {
		return clerk;
	}

	public void setClerk(String clerk) {
		this.clerk = clerk;
	}

	@Override
	public String toString() {
		return "RequestEntity [code=" + code + ", orderId=" + orderId + ", careTypeId=" + careTypeId
				+ ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", bedNum=" + bedNum
				+ ", clerk=" + clerk + "]";
	}

}
