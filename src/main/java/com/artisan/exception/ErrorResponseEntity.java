package com.artisan.exception;

/**
 * 定义返回的异常信息的格式，这样异常信息风格更为统一
 * @author yangshangwei
 *
 */

public class ErrorResponseEntity {
	private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public ErrorResponseEntity(){
    	
    }
    public ErrorResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
}
