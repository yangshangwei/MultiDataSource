package com.artisan.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -712380666351190919L;
	
	private int code ;
	
	public CustomException() {
		super();
	}
	
	public CustomException(int code , String message) {
		super(message);
		this.setCode(code);
	}
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
