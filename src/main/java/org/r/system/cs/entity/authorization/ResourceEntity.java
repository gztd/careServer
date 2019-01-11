/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.entity.authorization 
 * @author: Casper   
 * @date: 2018年11月22日 下午1:14:34 
 */
package org.r.system.cs.entity.authorization;

import lombok.Data;

/**
 * @author Casper
 *
 */
@Data
public class ResourceEntity {

	// 资源id
	private Integer id;
	// 父资源id
	private Integer faId;
	// 资源名称
	private String name;
	// uri地址
	private String uri;
	// 资源类型
	private String type;
	// 模块
	private String componet;
	// 图标
	private String icon;
	// 操作域
	private String scope;
	// 请求方法
	private String requestMethod;
	// 是否禁用
	private Boolean isDisabled;
	// 是否需要权限
	private Boolean isRequireAuth;
	// 版本号
	private String version;

}
