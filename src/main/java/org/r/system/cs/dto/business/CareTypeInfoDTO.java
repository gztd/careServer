package org.r.system.cs.dto.business;

import org.r.system.cs.entity.business.CareTypeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CareTypeInfoDTO extends CareTypeEntity{

	// 陪护属性名称
	private String propertyName;
	// 结算方式名称
	private String settleTypeName;

}
