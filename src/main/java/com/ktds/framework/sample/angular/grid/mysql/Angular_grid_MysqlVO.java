package com.ktds.framework.sample.angular.grid.mysql;

import com.ktdsframework.core.mvc.BaseVO;

public class Angular_grid_MysqlVO extends BaseVO{
    private static final long serialVersionUID = 1L;
    
    /** 
	 * @primarykey="emp_no"
	 * @tablename="employees" 
	 * @columename="emp_no" 
	 */
    private int emp_no;
    
    /** 
	 * @tablename="employees" 
	 * @columename="birth_date" 
	 */
    private String birth_date;
    
	/** 
	 * @tablename="employees" 
	 * @columename="first_name" 
	 */
    private String first_name;
    
    /** 
	 * @tablename="employees" 
	 * @columename="last_name" 
	 */
    private String last_name;
    
    /** 
	 * @tablename="employees" 
	 * @columename="gender" 
	 */
    private String gender;

	/** 
	 * @tablename="employees" 
	 * @columename="hire_date" 
	 */
    private String hire_date;
    
    public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
}
