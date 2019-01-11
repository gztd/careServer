/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.entity.authorization 
 * @author: Casper   
 * @date: 2018年11月19日 下午11:02:23 
 */
package org.r.system.cs.entity.authorization;

import java.sql.Timestamp;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class LogEntity {

	// 记录号
	private Long id;
	// 操作名称
	private String operationName;
	// 操作人
	private String operator;
	// 操作日期时间
	private Timestamp dateTime;
	// 请求接口
	private String interfaces;
	// 耗时
	private Double timeConsuming;
	// 请求源ip地址
	private String ipAddress;

}
