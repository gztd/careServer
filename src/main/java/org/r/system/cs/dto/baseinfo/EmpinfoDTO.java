package org.r.system.cs.dto.baseinfo;

import java.util.Date;

public class EmpinfoDTO {

	// 员工编号
	private String code;
	// 员工姓名
	private String name;
	// 员工身份证号
	private String idcard;
	// 当前页
	private int curpage = 1;
	// 每一页的大小
	private int pagesize = 10;
	// 开始时间
	private Date startdate;
	// 结束时间
	private Date enddate;
	// 联系方式
	private String phone;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "EmpinfoDto [code=" + code + ", name=" + name + ", idcard=" + idcard + ", curpage=" + curpage
				+ ", pagesize=" + pagesize + ", startdate=" + startdate + ", enddate=" + enddate + ", phone=" + phone
				+ "]";
	}

}
