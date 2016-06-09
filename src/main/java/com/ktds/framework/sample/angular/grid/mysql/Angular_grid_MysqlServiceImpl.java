package com.ktds.framework.sample.angular.grid.mysql;

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

@Service("angular_grid_mysqlService")
@Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED,value="mysql")
public class Angular_grid_MysqlServiceImpl extends BaseServiceImpl<Angular_grid_MysqlVO> implements Angular_grid_MysqlService {
    protected final Log log = LogFactory.getLog(getClass());
    
    @Autowired
    @Qualifier("angular_grid_mysqlDao")
    private Angular_grid_MysqlDao angular_grid_mysqlDao;
    
    @Override
    public List<Angular_grid_MysqlVO> select(Angular_grid_MysqlVO vo) {
        return angular_grid_mysqlDao.select(vo);
    }
    @Override
    public List<Angular_grid_MysqlVO> select(Angular_grid_MysqlVO vo, HashMap param) {
        return angular_grid_mysqlDao.select(vo, param);
    }
    /** Angular_gridVO Code generator */
    @Override
    public Integer insert(Angular_grid_MysqlVO vo) {
        return angular_grid_mysqlDao.insert(vo);
    }
    
    @Override
    public Integer insert(Angular_grid_MysqlVO vo, HashMap param) {
        return angular_grid_mysqlDao.insert(vo, param);
    }
}
