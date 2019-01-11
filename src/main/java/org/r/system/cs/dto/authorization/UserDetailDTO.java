/**
 * 
 */
package org.r.system.cs.dto.authorization;

import java.util.List;

import org.r.system.cs.entity.authorization.AuthorityEntity;

/**
 * @author Casper
 *
 */
public class UserDetailDTO {

	// 用户名
	private String username;
	// 密码
	private String password;
	// 权限
	private List<AuthorityEntity> authorities;

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

	public List<AuthorityEntity> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<AuthorityEntity> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "UserDetailDTO [username=" + username + ", password=" + password + ", authorities=" + authorities + "]";
	}

}
