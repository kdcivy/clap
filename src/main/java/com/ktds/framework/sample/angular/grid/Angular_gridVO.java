package com.ktds.framework.sample.angular.grid;

import com.ktdsframework.core.mvc.BaseVO;

public class Angular_gridVO extends BaseVO{
    private static final long serialVersionUID = 1L;
    
    /** 
	 * @primarykey="id"
	 * @tablename="angular_grid" 
	 * @columename="id" 
	 */
    private int id;
    
    /** 
	 * @tablename="angular_grid" 
	 * @columename="firstName" 
	 */
    private String firstName;
    
    /** 
	 * @tablename="angular_grid" 
	 * @columename="lastName" 
	 */
    private String lastName;
    
    /** 
	 * @tablename="angular_grid" 
	 * @columename="company" 
	 */
    private String company;
    
    /** 
	 * @tablename="angular_grid" 
	 * @columename="age" 
	 */
    private int age;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
