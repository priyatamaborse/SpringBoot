package com.yash.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorDetails> businessHandler(BusinessException businessException)
	{
		System.out.println("@RestControllerAdvice");
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(businessException.getMessage());
		errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
		
		ResponseEntity<ErrorDetails> error = new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		return error;
	}
}
