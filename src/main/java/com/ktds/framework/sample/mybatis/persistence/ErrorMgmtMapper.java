package com.ktds.framework.sample.mybatis.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.RowBounds;

import com.ktds.framework.sample.mybatis.domain.ErrorMgmt;

public interface ErrorMgmtMapper {

	@Options(resultSetType=ResultSetType.SCROLL_INSENSITIVE)
	List<ErrorMgmt> selectList(ErrorMgmt param,RowBounds rwobounds);
	
	List<ErrorMgmt> selectList(ErrorMgmt param);
}
