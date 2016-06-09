package com.ktds.framework.sample.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "sffw_employee_info")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(Employee.class);
	
	@Id
    private String emp_no;
    private String emp_nm;
    private String hire_date;
    
    public Employee(){
    	logger.debug("Employee Entity is created.");
    }
    public Employee(String emp_no,String emp_nm,String hire_date){
    	this.emp_no = emp_no;
    	this.emp_nm = emp_nm;
    	this.hire_date = hire_date;
    }

	@Override
	public String toString() {
		return "Employee [emp_no=" + emp_no + ", emp_nm=" + emp_nm
				+ ", hire_date=" + hire_date + "]";
	}
	
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_nm() {
		return emp_nm;
	}
	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	
}
