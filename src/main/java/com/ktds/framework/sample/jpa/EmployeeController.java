package com.ktds.framework.sample.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller("EmployeeJpaController")
public class EmployeeController {
	protected final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	@Qualifier("jpaEmployeeService")
	private EmployeeService employeeService;
	
	// 방식 1 : 확장자 .json으로 호출하는 경우 MappingJackson2JsonView 를 통해서 json 형태로 응답하는 경우
	@RequestMapping(value = "/employee/employeeListJpa1", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Employee> getfindAll(){
		List<Employee> result = employeeService.findAll();

		logger.debug("EmployeeController getfindAll() is called.");
		for(Employee person : result){
			logger.debug(person.toString());
		}
		
		return result;
	}
	
	// @Controller + @ResponseBody 조합의 의해서 json 형태로 응답하는 경우, RequestResponseBodyMethodProcessor
	@RequestMapping(value = "/employee/employeeListJpa2", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody List<Employee> getSelectList(){
		List<Employee> result = employeeService.findAll();

		logger.debug("EmployeeController getSelectList() is called.");
		for(Employee person : result){
			logger.debug(person.toString());
		}
		
		return result;
	}
}
