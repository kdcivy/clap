package com.ktds.framework.sample.jdbc;

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

@Controller("EmployeeJdbcController")
public class EmployeeController {
	protected final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	@Qualifier("employeeJdbcService")
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/employee/employeeListByJdbc", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody List<Employee> getSelectList(){
		List<Employee> result = employeeService.selectList(null);

		return result;
	}
}
