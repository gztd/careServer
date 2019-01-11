/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月9日 下午3:54:24 
 */
package org.r.system.cs.dto.business;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class ChangeServiceDTO {

	// 住院服务单id
	private Long id;
	// 经手人
	private String clerk;
	// 床号
	private String bedNum;
	// 陪护类型id
	private Integer careTypeId;
	// 科室id
	private Integer orgId;
	// 变更日期
	private String changeDate;
	//服务请求单编号
	private String requestCode;
	//获取上一个Service的结束时间//zackzou
	private String lastServiceEndDate;

	

}
