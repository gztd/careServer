/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月11日 下午5:21:33 
 */
package org.r.system.cs.dto.business;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class MissionDetailInfoDTO {
	
	//病人姓名
	private String patientName;
	//病人编号
	private String patientCode;
	//服务单id
	private Long orderId;
	//服务单编号
	private String orderCode;
	//陪护人员id
	private Long careworkerId;
	//陪护人员编号
	private String careworkerCode;
	//陪护人员姓名
	private String careworkerName;
	//任务单日期
	private String missionDate;
	//服务请求单编号
	private String requestCode;
	//服务请求单经手人
	private String clerk;
	//床号
	private String bedNum;
	//服务请求单开始日期
	private String requestStartDate;
	//服务请求单结束日期
	private String requestEndDate;
	//陪护类型名称
	private String careTypeName;
	//陪护类型价格
	private Double careTypePrice;
	//陪护类型属性
	private Object careTypePorperty;
	//陪护类型结算方式
	private Object careTypeSettleType;
	//科室名称
	private String orgName;
	//科室id
	private Integer orgId;

}
