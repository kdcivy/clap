package com.ktds.framework.sample.mybatis.domain;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5678631330841098048L;
	
    private String empNo;
    
    private String empNm;
    
    private String hireDate;
    
    private String startDate;
    
    private String endDate;

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empNm=" + empNm + ", hireDate="
				+ hireDate + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
    
}
