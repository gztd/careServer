/**
 * 
 */
package org.r.system.cs.entity.authorization;

import java.util.List;

/**
 * @author Casper
 *
 */
public class AuthorityEntity {

	// 项目记录号
	private Object paID;
	// 角色记录号
	private List<Object> subId;

	public Object getPaID() {
		return paID;
	}

	public void setPaID(Object paID) {
		this.paID = paID;
	}

	public List<Object> getSubId() {
		return subId;
	}

	public void setSubId(List<Object> subId) {
		this.subId = subId;
	}

	@Override
	public String toString() {
		return "AuthorityEntity [paID=" + paID + ", subId=" + subId + "]";
	}

}
