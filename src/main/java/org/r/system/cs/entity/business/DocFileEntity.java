package org.r.system.cs.entity.business;

import lombok.Data;

@Data
public class DocFileEntity {

	// 记录号
	protected Integer id;
	// 名称
	protected String name;
	// 开始编号
	protected String startCode;
	// 当前编号
	protected String currentCode;
	// 结束编号
	protected String endCode;
	// 项目记录号
	protected Integer projectId;

}
