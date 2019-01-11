/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月8日 上午10:53:06 
 */
package org.r.system.cs.dto.business;

import java.text.ParseException;

import org.r.system.cs.entity.business.RequestEntity;
import org.r.system.cs.util.tool.UtilTool;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Casper
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class RequestInfoDTO extends RequestEntity {

	// 服务开始时间
	private String startTime;
	// 服务结束时间
	private String endTime;

	public RequestEntity build() throws ParseException {
		RequestEntity request = this;
		request.setStartDateTime(UtilTool.getTimestampByDateTimeString(this.startTime));
		if (this.endTime != null) {
			request.setEndDateTime(UtilTool.getTimestampByDateTimeString(endTime));
		}
		return request;
	}

}
