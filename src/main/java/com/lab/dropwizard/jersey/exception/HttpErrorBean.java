package com.lab.dropwizard.jersey.exception;

public class HttpErrorBean {

	private String httpStatus;
	private String code;
	private String message;
	
	/**
	 * @return the httpStatus
	 */
	public String getHttpStatus() {
		return httpStatus;
	}
	
	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
