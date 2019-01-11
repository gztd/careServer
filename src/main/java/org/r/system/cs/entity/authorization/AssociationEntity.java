/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.entity.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 上午9:33:10 
 */
package org.r.system.cs.entity.authorization;

import java.sql.Timestamp;

/**
 * @author Casper
 *
 */
public class AssociationEntity {

	// 记录号
	protected Integer id;
	// 角色ID
	private Integer roleId;
	// 项目ID
	protected Integer businessDbId;
	// 用户名
	protected String username;
	// 创建时间
	private Timestamp createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getBusinessDbId() {
		return businessDbId;
	}

	public void setBusinessDbId(Integer businessDbId) {
		this.businessDbId = businessDbId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AssociationEntity [id=" + id + ", roleId=" + roleId + ", businessDbId=" + businessDbId + ", username="
				+ username + ", createTime=" + createTime + "]";
	}

}
