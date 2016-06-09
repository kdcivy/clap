package com.ktds.framework.sample.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaEmployeeService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class}, value="jpa")
public class EmployeeServiceImpl implements EmployeeService {
	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> results = employeeRepository.findAll();
		for(Employee person : results){
			logger.debug(person.toString());
		}
		
		return results;
	}

}
