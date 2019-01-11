/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.gztc.cs.baseinfo.patient.util 
 * @author: Casper   
 * @date: 2018年10月27日 上午9:45:43 
 */
package org.r.system.cs.util.dto;

/**
 * @author Casper
 *
 */
public class PageDTO {

	// 页大小
	private Integer pageSize;
	// 当前页
	private Integer curPage;
	// 结果总条数
	private Integer totalSize;
	// 一页结果
	private Object result;

	public PageDTO(Integer pageSize, Integer curPage, Integer totalSize) {
		this.pageSize = pageSize;
		this.curPage = curPage;
		this.totalSize = totalSize;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PageDTO [pageSize=" + pageSize + ", curPage=" + curPage + ", totalSize=" + totalSize + ", result="
				+ result + "]";
	}

}
