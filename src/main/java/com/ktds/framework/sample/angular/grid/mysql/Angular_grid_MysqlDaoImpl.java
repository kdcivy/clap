package com.ktds.framework.sample.angular.grid.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("angular_grid_mysqlDao")
public class Angular_grid_MysqlDaoImpl implements Angular_grid_MysqlDao{
    protected final Logger logger = LoggerFactory.getLogger(Angular_grid_MysqlDaoImpl.class);
    
	@Autowired
	@Qualifier("mybatisSqlSession2")
	private SqlSession sqlSession;
	
    // select
	@Override
    public List<Angular_grid_MysqlVO> select(Angular_grid_MysqlVO vo, HashMap param) {
        logger.info("select(obj, param) invoked...");
        
        return sqlSession.selectList("com.ktds.framework.sample.mysql.EmployeeMysqlMapper." + param.get("mapperInfo"), vo);
        
    }
    @Override
    public List<Angular_grid_MysqlVO> select(Angular_grid_MysqlVO vo) {
        logger.info("select(obj) invoked...");
        
        return sqlSession.selectList("com.ktds.framework.sample.mysql.EmployeeMysqlMapper.selectList", vo);
        
    }
    // insert
    @Override
    public Integer insert(Angular_grid_MysqlVO vo) {
        logger.info("insert(obj) invoked...");
        
        return sqlSession.insert("com.ktds.framework.sample.mysql.EmployeeMysqlMapper.insert", vo);
        
    }
    @Override
    public Integer insert(Angular_grid_MysqlVO vo, HashMap param) {
        logger.info("insert(obj, param) invoked...");
        
        return sqlSession.insert("com.ktds.framework.sample.mysql.EmployeeMysqlMapper." + param.get("mapperInfo"), vo);
        
    }
}
