package com.ktds.framework.sample.mybatis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktds.framework.sample.mybatis.domain.ErrorMgmt;
import com.ktds.framework.sample.mybatis.persistence.ErrorMgmtMapper;

@Service("errorMgmtService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class}, value="ppas")
public class ErrorMgmtServiceImpl implements ErrorMgmtService {
	private static Logger logger = LoggerFactory.getLogger(ErrorMgmtServiceImpl.class);
	
	@Autowired
	private ErrorMgmtMapper errorMgmtMapper;
	
	@Override
	public List<ErrorMgmt> select(ErrorMgmt errorMgmtVO) {
		// TODO Auto-generated method stub
		//List<ErrorMgmt> errors = errorMgmtMapper.selectList(errorMgmtVO, new RowBounds(0,10));
		List<ErrorMgmt> errors = errorMgmtMapper.selectList(errorMgmtVO);
		for(ErrorMgmt error : errors){
			logger.debug(error.toString());
		}
		
		return errors;
	}
}
