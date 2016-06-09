package com.ktds.framework.sample.mybatis.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.RowBounds;

import com.ktds.framework.sample.mybatis.domain.Employee;

public interface EmployeeMapper {

	List<Employee> selectList(Employee param);
	
	@Options(resultSetType=ResultSetType.SCROLL_INSENSITIVE)
	List<Employee> selectList(Employee param,RowBounds rwobounds);
	
	int insertEmployee(Employee param);
}
