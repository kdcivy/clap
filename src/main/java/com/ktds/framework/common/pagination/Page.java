package com.ktds.framework.common.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable{

	private static final long serialVersionUID = -8356597494477841854L;

	// 전체 레코드 개수
	private final int totalRowCount;
	// 현재 페이지 번호
	private final int pageNumber;
	// 전체 페이지 수(rowCount / pageSize)
    private final int pagesCount;
    // 현재 페이지에 있는 객체 T 배열
    private List<T> content = new ArrayList<T>();
    
    public Page(List<T> content,int totalRowCount,int pageNumber,int pagesCount){
    	this.content.addAll(content);
    	this.totalRowCount = totalRowCount;
    	this.pageNumber = pageNumber;
    	this.pagesCount = pagesCount;
    }

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPagesCount() {
		return pagesCount;
	}

	@Override
	public String toString() {
		return "Page [totalRowCount=" + totalRowCount + ", pageNumber="
				+ pageNumber + ", pagesCount=" + pagesCount + ", content="
				+ content + "]";
	}
    
}
