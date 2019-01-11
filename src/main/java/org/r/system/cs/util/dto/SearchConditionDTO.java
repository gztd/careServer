/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.util.dto 
 * @author: Casper   
 * @date: 2018年10月31日 下午8:34:53 
 */
package org.r.system.cs.util.dto;

/**
 * @author Casper
 *
 */
public class SearchConditionDTO {

	// 编号
	private String code;
	// 姓名
	private String name;
	// 身份证
	private String idCard;
	// 性别
	private Integer sex;
	// 联系方式
	private String contact;
	// 联系地址
	private String address;
	// 联系人
	private String linkman;
	// 区间开始时间
	private String startDate;
	// 区间结束时间
	private String endDate;
	// 当前页
	private Integer curPage = 1;
	// 页大小
	private Integer pageSize = 10;

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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "SearchConditionDTO [code=" + code + ", name=" + name + ", idCard=" + idCard + ", sex=" + sex
				+ ", contact=" + contact + ", address=" + address + ", linkman=" + linkman + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", curPage=" + curPage + ", pageSize=" + pageSize + "]";
	}

}
