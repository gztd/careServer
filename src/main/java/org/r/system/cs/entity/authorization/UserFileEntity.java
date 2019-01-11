/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.entity.authorization 
 * @author: Casper   
 * @date: 2018年11月1日 上午9:32:34 
 */
package org.r.system.cs.entity.authorization;

/**
 * @author Casper
 *
 */
public class UserFileEntity {

	// 用户名
	private String username;
	// 用户密码
	private String password;
	// 是否锁上
	private Boolean isLocked;
	// 是否禁用
	private Boolean isDisabled;
	// 头像
	private String icon;
	// 别名
	private String nickname;

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

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Boolean getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "UserFileEntity [username=" + username + ", password=" + password + ", isLocked=" + isLocked
				+ ", isDisabled=" + isDisabled + ", icon=" + icon + ", nickname=" + nickname + "]";
	}

}
