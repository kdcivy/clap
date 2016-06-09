package com.ktds.framework.sample.web;

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
import com.ktds.framework.sample.mybatis.domain.ErrorMgmt;
import com.ktds.framework.sample.mybatis.service.EmployeeService;
import com.ktds.framework.sample.mybatis.service.ErrorMgmtService;


@Controller("viewResolverController")
public class ViewResolverTestController {
	protected final Logger logger = LoggerFactory.getLogger(ViewResolverTestController.class);
	
	@Autowired
	@Qualifier("mybatisEmployeeService")
	private EmployeeService employeeService;
	
	@Autowired
	@Qualifier("errorMgmtService")
	private ErrorMgmtService errorMgmtService;
	
	// 방식 1 : 확장자 .json으로 호출하는 경우 MappingJackson2JsonView 를 통해서 json 형태로 응답하는 경우
	@RequestMapping(value = "/sample/employeeList1", method = { RequestMethod.POST, RequestMethod.GET })//produces={"application/xml", "application/json"}
	public List<Employee> getSelectListOne(){
		List<Employee> result = employeeService.selectList(null);

		return result;
	}
	
	// @Controller + @ResponseBody 조합의 의해서 json 형태로 응답하는 경우, RequestResponseBodyMethodProcessor
	@RequestMapping(value = "/sample/employeeList2", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<Employee> getSelectListTwo(){
		List<Employee> result = employeeService.selectList(null);

		return result;
	}
	
	@RequestMapping(value = "/sample/errorList", method = { RequestMethod.POST, RequestMethod.GET })
	public List<ErrorMgmt> getErrors(){
		List<ErrorMgmt> errors = errorMgmtService.select(null);
		
		return errors;
	}
}
