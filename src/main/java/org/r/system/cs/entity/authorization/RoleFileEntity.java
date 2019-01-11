/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.entity.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 上午9:32:45 
 */
package org.r.system.cs.entity.authorization;

/**
 * @author Casper
 *
 */
public class RoleFileEntity {

	// 角色ID
	private Integer id;
	// 角色名称
	private String roleName;
	// 是否不可用
	private Boolean isDisabled;

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

	@Override
	public String toString() {
		return "RoleFileEntity [id=" + id + ", roleName=" + roleName + ", isDisabled=" + isDisabled + "]";
	}

}
