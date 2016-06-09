package com.ktds.framework.sample.angular.grid;

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

@Service("angular_gridService")
@Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED,value="ppas")
public class Angular_gridServiceImpl extends BaseServiceImpl<Angular_gridVO> implements Angular_gridService {
    protected final Log log = LogFactory.getLog(getClass());
    
    @Autowired
    @Qualifier("angular_gridDao")
    private Angular_gridDao angular_gridDao;
    
    @Override
    public List<Angular_gridVO> select(Angular_gridVO vo) {
        return angular_gridDao.select(vo);
    }
    @Override
    public List<Angular_gridVO> select(Angular_gridVO vo, HashMap param) {
        return angular_gridDao.select(vo, param);
    }
    /** Angular_gridVO Code generator */
    @Override
    public Integer insert(Angular_gridVO vo) {
        return angular_gridDao.insert(vo);
    }
    
    @Override
    public Integer insert(Angular_gridVO vo, HashMap param) {
        return angular_gridDao.insert(vo, param);
    }
    
    @Override
    public Integer update(Angular_gridVO vo) {
        return angular_gridDao.update(vo);
    }
    
    @Override
    public Integer update(Angular_gridVO vo, HashMap param) {
        return angular_gridDao.update(vo, param);
    }
    
    @Override
    public Integer delete(Angular_gridVO vo) {
        return angular_gridDao.delete(vo);
    }
    
}
