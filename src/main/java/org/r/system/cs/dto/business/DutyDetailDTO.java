/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月11日 下午10:09:27 
 */
package org.r.system.cs.dto.business;

import java.util.List;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class DutyDetailDTO {

	// 陪护人员姓名
	private String careworkerName;
	// 陪护人员id
	private Long careworkerId;
	// 常规日程
	private List<RoutineInfoDTO> routineInfoDTO;

}
