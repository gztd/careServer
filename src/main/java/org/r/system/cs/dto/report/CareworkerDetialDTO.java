/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.report 
 * @author: Casper   
 * @date: 2018年11月10日 下午4:01:56 
 */
package org.r.system.cs.dto.report;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.r.system.cs.entity.report.CareworkerEntity;

/**
 * @author Casper
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CareworkerDetialDTO extends CareworkerEntity {

	// 科室名称
	private String orgName;
	// 科室编号
	private Integer orgId;

}
