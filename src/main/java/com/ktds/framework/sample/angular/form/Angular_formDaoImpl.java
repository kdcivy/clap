package com.ktds.framework.sample.angular.form;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("angular_formDao")
public class Angular_formDaoImpl implements Angular_formDao{
    protected final Logger logger = LoggerFactory.getLogger(Angular_formDaoImpl.class);
    
	@Autowired
	@Qualifier("mybatisSqlSession")
	private SqlSession sqlSession;
	
    // select
	@Override
    public List<Angular_formVO> select(Angular_formVO vo, HashMap param) {
        logger.info("select(obj, param) invoked...");
        
        return sqlSession.selectList("com.sample.common.form." + param.get("mapperInfo"), vo);
        
    }
    @Override
    public List<Angular_formVO> select(Angular_formVO vo) {
        logger.info("select(obj) invoked...");
        
        return sqlSession.selectList("com.sample.common.form.selectList", vo);
        
    }
    // insert
    @Override
    public Integer insert(Angular_formVO vo) {
        logger.info("insert(obj) invoked...");
        
        return sqlSession.update("com.sample.common.form.insert", vo);
        
    }
    @Override
    public Integer insert(Angular_formVO vo, HashMap param) {
        logger.info("insert(obj, param) invoked...");
        
        return sqlSession.update("com.sample.common.form." + param.get("mapperInfo"), vo);
        
    }
    // update
    @Override
    public Integer update(Angular_formVO vo) {
        logger.info("update(obj) invoked...");
        
        return sqlSession.update("com.sample.common.form.update", vo);
        
    }
    @Override
    public Integer update(Angular_formVO vo, HashMap param) {
        logger.info("update(obj, param) invoked...");
        
        return sqlSession.update("com.sample.common.form." + param.get("mapperInfo"), vo);
        
    }
    // delete
    @Override
    public Integer delete(Angular_formVO vo) {
        logger.info("delete(obj) invoked...");
        
        return sqlSession.update("com.sample.common.form.delete", vo);
        
    }
}
