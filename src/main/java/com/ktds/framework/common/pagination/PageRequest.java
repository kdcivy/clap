package com.ktds.framework.common.pagination;

import java.io.Serializable;

public class PageRequest implements Serializable{

	private static final long serialVersionUID = -1477382948710006673L;
	
	private final int page;
	private final int size;

	public PageRequest(int page, int size) {

		if (page < 0) {
			throw new IllegalArgumentException("Page index must not be less than zero!");
		}

		if (size < 1) {
			throw new IllegalArgumentException("Page size must not be less than one!");
		}

		this.page = page;
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}
	public int getOffset() {
		return page * size;
	}

	@Override
	public String toString() {
		return "PageRequest [page=" + page + ", size=" + size + ",offset=" + getOffset() + "]";
	}
	
}
