package com.yash.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public BusinessException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage() {
		return this.msg;
	}

}
