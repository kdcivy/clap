package com.ktds.framework.sample.mybatis.service;

import java.util.List;

import com.ktds.framework.sample.mybatis.domain.ErrorMgmt;

public interface ErrorMgmtService {
	
    public List<ErrorMgmt> select(ErrorMgmt errorMgmtVO) ;
}
