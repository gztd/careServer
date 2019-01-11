package org.r.system.cs.entity.baseinfo;

import java.util.Date;

public class BehaivorEntity {
	// 记录时间
	private Date datetime;
	// 事件
	private String event;
	// 服务单据号
	private String recordcode;
	// 项目记录号
	private int projectid;
	// 评价
	private int grade;
	// 员工记录号
	private String employeeid;

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getRecordcode() {
		return recordcode;
	}

	public void setRecordcode(String recordcode) {
		this.recordcode = recordcode;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

}
