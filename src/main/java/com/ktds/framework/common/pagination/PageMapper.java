package com.ktds.framework.common.pagination;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PageMapper<T,P> {
	public int countAll();
	//@Options(resultSetType=ResultSetType.SCROLL_INSENSITIVE)
	public List<T> selectPage(@Param("param") P parameter,@Param("rowBounds") RowBounds rowBounds);
	public List<T> selectPage(@Param("userParam") P parameter,@Param("offset") int offset,@Param("limit") int limit);
}
