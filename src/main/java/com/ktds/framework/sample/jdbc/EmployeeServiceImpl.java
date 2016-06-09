package com.ktds.framework.sample.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ktds.framework.sample.mybatis.domain.Employee;

@Service("employeeJdbcService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class}, value="ppas")
public class EmployeeServiceImpl implements EmployeeService {
	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	@Qualifier("employeeJdbcDao")
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> selectList(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeDao.selectList(employee);
		for(Employee person : employees){
			logger.debug(person.toString());
		}
		
		return employees;
	}

}
