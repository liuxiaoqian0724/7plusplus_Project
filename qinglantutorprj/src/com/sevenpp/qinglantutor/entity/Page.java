package com.sevenpp.qinglantutor.entity;

import java.util.List;

public class Page<T> {

	private int currentPageNum;
	private int pageSize;
	private int prePageNum;
	private int nextPageNum;
	private int totalPageNum;
	private int totalCount;
	private List<T> list;
	
	public Page(int pageNum,int pageSize) {
		this.currentPageNum=pageNum;
		this.pageSize=pageSize;
	}
	public Page(int pageSize, int prePageNum, int totalCount, List<T> list) {
		super();
		this.pageSize = pageSize;
		this.prePageNum = prePageNum;
		this.totalCount = totalCount;
		this.list = list;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPrePageNum() {
		return prePageNum;
	}
	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
		if(totalCount%pageSize==0) {
			totalPageNum=totalCount/pageSize;
		}else {
			totalPageNum=(totalCount/pageSize)+1;
		}
		if(currentPageNum>1)
			prePageNum=currentPageNum-1;
		else
			prePageNum=1;
		
		if(currentPageNum<totalPageNum)
			nextPageNum=currentPageNum+1;
		else
			nextPageNum=totalPageNum;
		
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}
