/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月11日 下午2:04:00 
 */
package org.r.system.cs.dto.business;

import java.util.List;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class ListDTO<T> {

	// 列表
	private List<T> result;
	// 列表大小，分页查询时为不加分页限制的所有结果数量
	private Integer size;

}
