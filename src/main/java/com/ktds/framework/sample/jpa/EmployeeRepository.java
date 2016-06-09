package com.ktds.framework.sample.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String>{
	List<Employee> findAll();
}
