package com.ktds.framework.sample.mybatis.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.framework.sample.mybatis.domain.Employee;
import com.ktds.framework.sample.mybatis.service.EmployeeService;

@Controller("employeeController")
public class EmployeeController {
	 protected final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	 
	@Autowired
	@Qualifier("mybatisEmployeeService")
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employee/employeeList", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody List<Employee> getSelectList(){
		List<Employee> result = employeeService.selectList(null);

		return result;
	}

	@RequestMapping(value = "/employee/employeeListDao", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody List<Employee> getSelectListDao(){
		logger.debug("[EmployeeController] selectListbyDao is invoked.");
		List<Employee> result = employeeService.selectListbyDao(null);

		return result;
	}
	
	@RequestMapping(value = "/employee/insertEmployee", method = { RequestMethod.POST, RequestMethod.GET })
	public void insertEmployee(){
		Employee my = new Employee();
		my.setEmpNo("200509");
		my.setEmpNm("이창건");
		my.setHireDate("20050901");
		
		logger.debug("insertEmployee() rows=" + employeeService.insertEmployee(my));
	}
}
