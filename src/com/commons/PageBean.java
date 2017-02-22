package com.commons;

import java.util.List;

public class PageBean<T> {

	private int pageNumber;//当前页的页码
	private int pageSize;//每页显示的记录条数
	private int totalRecords;//符合条件的总记录条数
	//private int totalPages;//总页数
	private List<T> list;//指定页码显示的内容
	private String url;//存放URL

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotalPages() {
		return (totalRecords+pageSize-1)/pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
