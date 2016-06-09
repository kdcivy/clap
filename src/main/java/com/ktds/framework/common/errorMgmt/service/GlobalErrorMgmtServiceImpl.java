package com.ktds.framework.common.errorMgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktds.framework.common.errorMgmt.ErrorMgmtVO;
import com.ktds.framework.common.errorMgmt.mapper.GlobalErrorMgmtMapper;

@Service
@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class}, value="ppas")
public class GlobalErrorMgmtServiceImpl implements GlobalErrorMgmtService{
	
	@Autowired
	private GlobalErrorMgmtMapper errorMgmtMapper;
	
	@Override
    public Integer insert(ErrorMgmtVO errorMgmtVO)  {
        // TODO Auto-generated method stub
        return errorMgmtMapper.insMasterData(errorMgmtVO);
    }
}
