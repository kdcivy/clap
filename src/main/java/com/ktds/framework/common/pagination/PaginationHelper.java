package com.ktds.framework.common.pagination;

import java.util.List;

public class PaginationHelper<T>{

	public Page<T> fetchPage(PageMapper<T, Object> pageMapper,
			Object param,PageRequest pageRequest){
		// 전체 레코드 건수 구하기
		int rowCount = pageMapper.countAll();
        // page 수 계산
        int pageCount = rowCount / pageRequest.getSize();
        if (rowCount > pageRequest.getSize() * pageCount) {
            pageCount++;
        }
        
		// 지정된 페이지의 레코드 DataSet 구하기
		List<T> pages = pageMapper.selectPage(param,pageRequest.getOffset(),pageRequest.getSize());

/*		List<T> pages = pageMapper.selectPage(param,
				new RowBounds(pageRequest.getOffset(),pageRequest.getSize()));*/
		
		return new Page<T>(pages,rowCount,pageRequest.getPage(),pageCount);
	}
}
