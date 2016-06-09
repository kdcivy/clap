package com.ktds.framework.sample.angular.form;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktdsframework.core.mvc.BaseServiceImpl;

@Service("angular_formService")
@Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED,value="ppas")
public class Angular_formServiceImpl extends BaseServiceImpl<Angular_formVO> implements Angular_formService {
    protected final Log log = LogFactory.getLog(getClass());
    
    @Autowired
    @Qualifier("angular_formDao")
    private Angular_formDao angularFormDao;
    
    @Override
    public List<Angular_formVO> select(Angular_formVO vo) {
        return angularFormDao.select(vo);
    }
    @Override
    public List<Angular_formVO> select(Angular_formVO vo, HashMap param) {
        return angularFormDao.select(vo, param);
    }
    /** Angular_formVO Code generator */
    @Override
    public Integer insert(Angular_formVO vo) {
        return angularFormDao.insert(vo);
    }
    
    @Override
    public Integer insert(Angular_formVO vo, HashMap param) {
        return angularFormDao.insert(vo, param);
    }
    
    @Override
    public Integer update(Angular_formVO vo) {
        return angularFormDao.update(vo);
    }
    
    @Override
    public Integer update(Angular_formVO vo, HashMap param) {
        return angularFormDao.update(vo, param);
    }
    
    @Override
    public Integer delete(Angular_formVO vo) {
        return angularFormDao.delete(vo);
    }
    
}
