package com.ktds.framework.sample.jdbc;

import java.util.List;

import com.ktds.framework.sample.mybatis.domain.Employee;

public interface EmployeeDao {
	public List<Employee> selectList(Employee param);
}
