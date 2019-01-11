/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.authorization 
 * @author: Casper   
 * @date: 2018年11月5日 下午10:23:06 
 */
package org.r.system.cs.dto.authorization;

import java.util.List;

import org.r.system.cs.entity.authorization.AssociationEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Casper
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AssociationDTO extends AssociationEntity {

	private List<Integer> roleIds;

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	@Override
	public String toString() {
		return "AssociationDTO [roleIds=" + roleIds + "]";
	}

}
