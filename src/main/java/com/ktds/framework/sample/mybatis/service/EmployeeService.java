package com.ktds.framework.sample.mybatis.service;

import java.util.List;

import com.ktds.framework.sample.mybatis.domain.Employee;

public interface EmployeeService {
	public List<Employee> selectList(Employee employee);
	public List<Employee> selectListbyDao(Employee employee);
	public int insertEmployee(Employee param);
}
