package com.ktds.framework.sample.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ktds.framework.sample.mybatis.domain.Employee;

@Repository("employeeJdbcDao")
public class EmployeeDaoImpl implements EmployeeDao {

	// private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	//@Autowired
	// private JdbcTemplate
    //private JdbcTemplate jdbcTemplate;

/*    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    */
	@Override
	public List<Employee> selectList(Employee param) {
		// TODO Auto-generated method stub
		//String sql = "select count(*) from T_ACTOR where first_name = :firstName and last_name = :lastName"; 
		String sql = "select emp_no empNo, emp_nm empNm, hire_date hireDate from sffw_employee_info";
		
		
		
		List<Employee> employees = this.namedParameterJdbcTemplate.query(sql,
				new RowMapper<Employee>() {
					@Override
					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						// TODO Auto-generated method stub
						String colName = "empNo";
						String empNo = rs.getString(0);
						Employee employee = new Employee();
						employee.setEmpNo(empNo);
						//employee.setEmpNo(rs.getString("empNo"));
						employee.setEmpNm(rs.getString("empNm"));
						employee.setHireDate(rs.getString("hireDate"));
						return employee;
					}
		});
		
		return employees;
	}

}
