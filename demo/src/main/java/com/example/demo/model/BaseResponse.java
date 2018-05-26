package com.example.demo.model;

/**
 * @author Quang Nguyen
 *
 */
public class BaseResponse {
	private int responseStatus;
	private String responseCode;
	private String message;
	
	public BaseResponse(int responseStatus, String responseCode, String message) {
		super();
		this.responseStatus = responseStatus;
		this.responseCode = responseCode;
		this.message = message;
	}
	public int getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
