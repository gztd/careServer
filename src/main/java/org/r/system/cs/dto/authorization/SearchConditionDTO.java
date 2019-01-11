/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.authorization 
 * @author: Casper   
 * @date: 2018年11月5日 上午10:07:55 
 */
package org.r.system.cs.dto.authorization;

import org.r.system.cs.util.dto.PageSizeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Casper
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SearchConditionDTO extends PageSizeDTO {

	// 用户名
	private String username;
	// 别名
	private String nickname;
	// 是否锁定
	private Boolean isLocked;
	// 是否不可用
	private Boolean isDisabled;
	// 角色名
	private String roleName;
	// 项目名
	private String projectName;
	// 开始时间
	private String startDate;
	// 结束时间
	private String endDate;

}
