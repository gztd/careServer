/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.dto.business 
 * @author: Casper   
 * @date: 2018年11月15日 下午5:00:50 
 */
package org.r.system.cs.util.dto;

/**
 * @author Casper
 *
 */
public class PageSizeDTO {

	// 页大小
	protected Integer pageSize = 10;
	// 当前页
	protected Integer curPage = 0;
	// 原始当前页
	private Integer curPageOrg = 1;
	// 结果总条数
	protected Integer totalSize;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurPageOrg() {
		return curPageOrg;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPageOrg = curPage;
		this.curPage = (curPage - 1) * 10;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public String toString() {
		return "PageSizeDTO [pageSize=" + pageSize + ", curPage=" + curPage + ", totalSize=" + totalSize + "]";
	}

}
