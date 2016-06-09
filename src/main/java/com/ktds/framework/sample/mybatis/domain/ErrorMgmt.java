package com.ktds.framework.sample.mybatis.domain;

import java.io.Serializable;

public class ErrorMgmt implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		this.errorMessage = errorMessage;
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
	@Override
	public String toString() {
		return "ErrorMgmt [errorNo=" + errorNo + ", errorCode=" + errorCode
				+ ", errorName=" + errorName + ", errorType=" + errorType
				+ ", errorMessage=" + errorMessage + ", occurClass="
				+ occurClass + ", occurMethod=" + occurMethod + ", occurTime="
				+ occurTime + "]";
	}
}
