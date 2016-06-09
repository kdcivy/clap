package com.ktds.framework.sample.angular.form;

import com.ktdsframework.core.mvc.BaseVO;

public class Angular_formVO extends BaseVO{
    private static final long serialVersionUID = 1L;
    
    /** 
	 * @primarykey="id"
	 * @tablename="angular_form" 
	 * @columename="id" 
	 */
    private int id;
    
    /** 
	 * @tablename="angular_form" 
	 * @columename="email" 
	 */
    private String email;
    
    /** 
	 * @tablename="angular_form" 
	 * @columename="password" 
	 */
    private String password;
    
    /** 
	 * @tablename="angular_form" 
	 * @columename="username" 
	 */
    private String username;
    
    /** 
	 * @tablename="angular_form" 
	 * @columename="cellphone" 
	 */
    private String cellphone;
    
    /** 
	 * @tablename="angular_form" 
	 * @columename="soccer" 
	 */
    private String soccer;
    
    /** 
	 * @tablename="angular_form" 
	 * @columename="baseball" 
	 */
    private String baseball;
    
    /** 
	 * @tablename="angular_form" 
	 * @columename="basketball" 
	 */
    private String basketball;
    
    /** 
	 * @tablename="angular_form" 
	 * @columename="volleyball" 
	 */
    private String volleyball;
    
    /** 
	 * @tablename="angular_form" 
	 * @columename="agegroup" 
	 */
    private String agegroup;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getCellphone() {
        return this.cellphone;
    }
    
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    public String getSoccer() {
        return this.soccer;
    }
    
    public void setSoccer(String soccer) {
        this.soccer = soccer;
    }
    public String getBaseball() {
        return this.baseball;
    }
    
    public void setBaseball(String baseball) {
        this.baseball = baseball;
    }
    public String getBasketball() {
        return this.basketball;
    }
    
    public void setBasketball(String basketball) {
        this.basketball = basketball;
    }
    public String getVolleyball() {
        return this.volleyball;
    }
    
    public void setVolleyball(String volleyball) {
        this.volleyball = volleyball;
    }
    public String getAgegroup() {
        return this.agegroup;
    }
    
    public void setAgegroup(String agegroup) {
        this.agegroup = agegroup;
    }
}
