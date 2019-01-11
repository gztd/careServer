package org.r.system.cs.dto.business;

import org.r.system.cs.entity.business.OrganizationEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OrganizationDTO extends OrganizationEntity{

	private Boolean isLeaf;
	
	
}
