package com.sonhaenono.exception;

import org.springframework.http.HttpStatus;

public class ApiExceptionEntity {
	private String errorCode;
	private String errorMessage;
	
	public ApiExceptionEntity(HttpStatus status, String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ApiExceptionEntity [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	
	
}
