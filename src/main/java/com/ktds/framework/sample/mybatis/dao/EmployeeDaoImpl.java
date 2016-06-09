package com.ktds.framework.sample.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ktds.framework.sample.mybatis.domain.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	private final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	@Qualifier("mybatisSqlSession")
	private SqlSession sqlSession;
	
	@Override
	public List<Employee> selectList(Employee param) {
		// TODO Auto-generated method stub
		logger.debug("[EmployeeDaoImpl] selectList is called.");
		if(sqlSession == null){
			logger.error("[EmployeeDaoImpl] SqlSession is null;");
		}
		
		return sqlSession.selectList("com.ktds.framework.sample.mybatis.persistence.EmployeeMapper.selectList", param);
	}

}
