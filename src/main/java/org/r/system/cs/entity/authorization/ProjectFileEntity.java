/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.entity.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 上午9:32:56 
 */
package org.r.system.cs.entity.authorization;

import java.sql.Timestamp;

/**
 * @author Casper
 *
 */
public class ProjectFileEntity {

	// 项目id
	protected Integer id;
	// 项目编号
	protected String code;
	// 项目名称
	protected String name;
	// 项目数据库地址
	protected String url;
	// 是否不可用
	protected Boolean isDisabled;
	// 创建时间
	protected Timestamp createTime;
	// 创建人
	protected String creator;
	// 数据库驱动
	protected String driver;
	// 数据库用户名
	protected String username;
	// 数据库密码
	protected String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public Timestamp getMetaCreateTime() {
		return createTime;
	}
	
	public String getCreateTime() {
		return createTime.toString();
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ProjectFileEntity [id=" + id + ", code=" + code + ", url=" + url + ", isDisabled=" + isDisabled
				+ ", createTime=" + createTime + ", creator=" + creator + ", driver=" + driver + ", username="
				+ username + ", password=" + password + "]";
	}

}
