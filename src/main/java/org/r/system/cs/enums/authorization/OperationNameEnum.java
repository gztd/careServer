/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.enums.authorization 
 * @author: Casper   
 * @date: 2018年11月20日 上午12:11:17 
 */
package org.r.system.cs.enums.authorization;

/**
 * @author Casper
 *
 */
public enum OperationNameEnum {

	o1("添加科室", "/api/busi/baseinfo/organization", "POST"), 
	o2("修改科室", "/api/busi/baseinfo/organization", "PUT"), 
	o3("停用科室","/api/busi/baseinfo/organization", "DELETE"), 
	o4("查询科室", "/api/busi/baseinfo/organization/list", "GET"),
	o5(
					"查询科室详细信息", "/api/busi/baseinfo/organization",
					"GET"), o6("添加陪护类型", "/api/busi/baseinfo/caretype", "POST"), o7("修改陪护类型", "/api/busi/baseinfo/caretype",
							"PUT"), o8("查询陪护类型列表", "/api/busi/baseinfo/caretype/list", "POST"), o9("查询陪护类型详细信息",
									"/api/busi/baseinfo/caretype",
									"GET"), o10("添加单据信息", "/api/busi/baseinfo/docfile", "POST"), o11("修改单据信息",
											"/api/busi/baseinfo/docfile",
											"PUT"), o12("查询单据信息列表", "/api/busi/baseinfo/docfile/list", "POST"), o13(
													"查询单据详细信息", "/api/busi/baseinfo/docfile",
													"GET"), o14("入院登记", "/api/busi/patient", "POST"), o15("出院登记",
															"/api/busi/patient",
															"DELETE"), o16("变更服务", "/api/busi/patient", "PUT"), o17(
																	"查询住院信息列表", "/api/busi/patient/list", "POST"), o18(
																			"查询住院信息详情", "/api/busi/patient", "GET"), o19(
																					"获取病人余额", "/api/busi/patient/balance",
																					"GET"), o20("续费",
																							"/api/busi/patient/balance",
																							"POST"), o21("查询病人服务记录",
																									"/api/busi/patient/service/list",
																									"GET"), o22(
																											"查询病人的续费记录",
																											"/api/busi/patient/transaction/list",
																											"GET"), o23(
																													"获取服务总金额",
																													"/api/busi/patient/service/amount",
																													"GET"), o24(
																															"添加员工",
																															"/api/busi/careworker",
																															"POST"), o25(
																																	"员工离职",
																																	"/api/busi/careworker",
																																	"DELETE"), o26(
																																			"查询陪护人员信息列表",
																																			"/api/busi/careworker/list",
																																			"POST"), o27(
																																					"查询陪护人员详细信息",
																																					"/api/busi/careworker",
																																					"GET"), o28(
																																							"查询陪护任务",
																																							"/api/busi/mission/list",
																																							"POST"), o29(
																																									"结束陪护任务",
																																									"/api/busi/mission",
																																									"DELETE"), o30(
																																											"派遣陪护人员",
																																											"/api/busi/mission",
																																											"POST"), o31(
																																													"查询派遣记录",
																																													"/api/busi/mission/detail",
																																													"POST"), o32(
																																															"制定陪护人员值勤表",
																																															"/api/busi/routine",
																																															"POST"), o33(
																																																	"查询陪护人员值勤信息",
																																																	"/api/busi/routine/list",
																																																	"POST"), o34(
																																																			"修改陪护人员值勤信息接口",
																																																			"/api/busi/routine",
																																																			"PUT"), o35(
																																																					"陪护人员工资统计报表",
																																																					"/api/report/salary",
																																																					"POST"), o36(
																																																							"科室收支报表",
																																																							"/api/report/org",
																																																							"POST"), o37(
																																																									"病人住院信息报表",
																																																									"/api/report/patient",
																																																									"POST"), o38(
																																																											"陪护人员工资报表导出",
																																																											"/api/report/salary/file",
																																																											"POST"), o39(
																																																													"病人住院信息报表导出",
																																																													"/api/report/patient/file",
																																																													"POST"), o40(
																																																															"添加用户",
																																																															"/api/aut/user",
																																																															"POST"), o41(
																																																																	"修改用户",
																																																																	"/api/aut/user",
																																																																	"PUT"), o42(
																																																																			"修改用户状态",
																																																																			"/api/aut/user",
																																																																			"DELETE"), o43(
																																																																					"查询用户列表",
																																																																					"/api/aut/user/list",
																																																																					"POST"), o44(
																																																																							"添加角色",
																																																																							"/api/aut/role",
																																																																							"POST"), o45(
																																																																									"修改角色",
																																																																									"/api/aut/role",
																																																																									"PUT"), o46(
																																																																											"修改角色状态",
																																																																											"/api/aut/role",
																																																																											"DELETE"), o47(
																																																																													"查询角色列表",
																																																																													"/api/aut/role/list",
																																																																													"POST"), o48(
																																																																															"查询角色资料",
																																																																															"/api/aut/role",
																																																																															"GET"), o49(
																																																																																	"添加项目",
																																																																																	"/api/aut/project",
																																																																																	"POST"), o50(
																																																																																			"修改项目",
																																																																																			"/api/aut/project",
																																																																																			"PUT"), o51(
																																																																																					"修改项目状态",
																																																																																					"/api/aut/project",
																																																																																					"DELETE"), o52(
																																																																																							"查询项目列表",
																																																																																							"/api/aut/project/list",
																																																																																							"POST"), o53(
																																																																																									"查询资源列表",
																																																																																									"/api/aut/resource/list",
																																																																																									"GET"), o54(
																																																																																											"添加关联关系",
																																																																																											"/api/aut/association",
																																																																																											"POST"), o55(
																																																																																													"修改关联关系",
																																																																																													"/api/aut/association",
																																																																																													"PUT"), o56(
																																																																																															"查询项目关联关系",
																																																																																															"/api/aut/association/project",
																																																																																															"GET"), o57(
																																																																																																	"查询角色关联关系",
																																																																																																	"/api/aut/association/role",
																																																																																																	"GET"), o58(
																																																																																																			"登陆",
																																																																																																			"/api/aut/token",
																																																																																																			"POST"), o59(
																																																																																																					"注销",
																																																																																																					"/api/aut/token",
																																																																																																					"PUT"), o60(
																																																																																																							"获取模块",
																																																																																																							"/api/aut/resource/module",
																																																																																																							"GET"), o61(
																																																																																																									"获取模块功能",
																																																																																																									"/api/aut/resource/module/function",
																																																																																																									"GET"), o62(
																																																																																																											"添加病人",
																																																																																																											"/api/baseinfo/patient",
																																																																																																											"POST"), o63(
																																																																																																													"查询病人列表",
																																																																																																													"/api/baseinfo/patient/list",
																																																																																																													"GET"), o64(
																																																																																																															"查询病人详细信息",
																																																																																																															"/api/baseinfo/patient",
																																																																																																															"GET"), o65(
																																																																																																																	"修改病人资料",
																																																																																																																	"/api/baseinfo/patient",
																																																																																																																	"PUT"), o66(
																																																																																																																			"添加交易记录",
																																																																																																																			"/api/baseinfo/patient/transaction",
																																																																																																																			"POST"), o67(
																																																																																																																					"查询交易记录列表",
																																																																																																																					"/api/baseinfo/patient/transaction/list",
																																																																																																																					"GET"), o68(
																																																																																																																							"查询欠费记录列表",
																																																																																																																							"/api/baseinfo/patient/arrearage/list",
																																																																																																																							"GET"), o69(
																																																																																																																									"添加员工资料",
																																																																																																																									"/api/baseinfo/employee",
																																																																																																																									"POST"), o70(
																																																																																																																											"查询员工列表",
																																																																																																																											"/api/baseinfo/employee/list",
																																																																																																																											"GET"), o71(
																																																																																																																													"查询员工资料",
																																																																																																																													"/api/baseinfo/employee",
																																																																																																																													"GET"), o72(
																																																																																																																															"修改员工资料",
																																																																																																																															"/api/baseinfo/employee",
																																																																																																																															"PUT"), o73(
																																																																																																																																	"添加行为记录",
																																																																																																																																	"/api/baseinfo/employee/behavior",
																																																																																																																																	"POST"), o74(
																																																																																																																																			"查询行为记录列表",
																																																																																																																																			"/api/baseinfo/employee/behavior/list",
																																																																																																																																			"GET"), o75(
																																																																																																																																					"查询行为记录",
																																																																																																																																					"/api/baseinfo/employee/behavior","GET"),
	o76("查询操作记录","/api/aut/log","POST")
	{
																																																																																																																																			};
	private String value;
	private String name;
	private String method;

	private OperationNameEnum(String name, String value, String method) {
		this.value = value;
		this.name = name;
		this.method = method;
	}

	public static String getSate(String value,String method) {
		for (OperationNameEnum s : OperationNameEnum.values()) {
			if (s.getValue().equals(value) && s.getMethod().equals(method))
				return s.getName();
		}
		return null;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public String getMethod() {
		return method;
	}

}
