/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.dto.authorization 
 * @author: Casper   
 * @date: 2018年10月31日 下午8:21:58 
 */
package org.r.system.cs.dto.authorization;

/**
 * @author Casper
 *
 */
public class UserDTO {

	// 用户名
	private String username;
	// 密码
	private String password;
	// 是否被锁上
	private Boolean isLocked;
	// 是否不可用
	private Boolean isDisabled;
	// 别名
	private String nickname;
	// 头像
	private String icon;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", isLocked=" + isLocked + ", isDisabled="
				+ isDisabled + ", nickname=" + nickname + ", icon=" + icon + "]";
	}

}
