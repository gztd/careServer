/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.dto.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午8:24:55 
 */
package org.r.system.cs.dto.authorization;

import java.util.List;

/**
 * @author Casper
 *
 */
public class RoleDTO {

	// 角色id
	private Integer id;
	// 角色名
	private String roleName;
	// 是否不可用
	private Boolean isDisabled;
	// 角色拥有的资源id
	private List<Integer> auths;


	public List<Integer> getAuths() {
		return auths;
	}

	public void setAuths(List<Integer> auths) {
		this.auths = auths;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

}
