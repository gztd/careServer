/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月9日 下午3:06:09 
 */
package org.r.system.cs.dto.business;

import org.r.system.cs.entity.business.RequestDetailEntity;
import org.r.system.cs.enums.business.PropertyEnum;
import org.r.system.cs.enums.business.SettleTypeEnum;

/**
 * @author Casper
 *
 */
public class RequestDetailInfoDTO extends RequestDetailEntity {

	// 开始日期
	private String startDate;
	// 结束日期
	private String endDate;
	// 陪护属性名称
	private String propertyName;
	// 结算类型名称
	private String settleTypeName;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getSettleTypeName() {
		return settleTypeName;
	}

	public void setSettleTypeName(String settleTypeName) {
		this.settleTypeName = settleTypeName;
	}

	public RequestDetailInfoDTO(RequestDetailEntity request) {
		this.bedNum = request.getBedNum();
		this.careTypeId = request.getCareTypeId();
		this.careTypeName = request.getCareTypeName();
		this.clerk = request.getClerk();
		this.code = request.getCode();
		this.endDate = request.getEndDateTime() == null?null:request.getEndDateTime().toString();
		this.orderId = request.getOrderId();
		this.orgId = request.getOrgId();
		this.orgName = request.getOrgName();
		this.price = request.getPrice();
		this.propertyName = PropertyEnum.getSate(request.getProperty());
		this.settleTypeName = SettleTypeEnum.getSate(request.getSettleType());
		this.startDate = request.getStartDateTime().toString();
		this.days = request.getDays();
		this.amount = request.getAmount();
	}

	public RequestDetailInfoDTO() {
	}

}
