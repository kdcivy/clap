package com.ktds.framework.common.errorMgmt;

import java.io.Serializable;

public class ErrorMgmtVO implements Serializable{
    private static final long serialVersionUID = 7174497153047092707L;
    
    private String errorNo;
    
    private String errorCode;
    
    private String errorName;
    
    private String errorType;
    
    private String errorMessage;
    
    private String occurClass;
    
    private String occurMethod;
    
    private String occurTime;
    
    public String getErrorNo() {
        return errorNo;
    }
    
    public void setErrorNo(String errorNo) {
        this.errorNo = errorNo;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    public String getErrorName() {
        return errorName;
    }
    
    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }
    
    public String getErrorType() {
        return errorType;
    }
    
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        // ErrorMessage 특수문자 및 Html로 Json 형식이 깨지거나(: " 등) View Html(<td> 등) 깨짐
        this.errorMessage = Global.encodeHTML(errorMessage);
    }
    
    public String getOccurClass() {
        return occurClass;
    }
    
    public void setOccurClass(String occurClass) {
        this.occurClass = occurClass;
    }
    
    public String getOccurMethod() {
        return occurMethod;
    }
    
    public void setOccurMethod(String occurMethod) {
        this.occurMethod = occurMethod;
    }
    
    public String getOccurTime() {
        return occurTime;
    }
    
    public void setOccurTime(String occurTime) {
        this.occurTime = occurTime;
    }

    public String toString() {
    	return  super.toString()
    			+ "\n"
    			+ "errorNo:" + getErrorNo()
            	+ ", errorCode:" + getErrorCode()
            	+ ", errorName:" + getErrorName()
            	+ ", errorType:" + getErrorType()
            	+ ", errorMessage:" + getErrorMessage()
            	+ ", occurClass:" + getOccurClass()
            	+ ", occurMethod:" + getOccurMethod()
            	+ ", occurTime:" + getOccurTime();
    }
}
