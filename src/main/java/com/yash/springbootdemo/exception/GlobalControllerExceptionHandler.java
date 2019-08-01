package com.yash.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorDetails> validationHandler(ValidationException validationException)
	{
		System.out.println("@ControllerAdvice");
		ErrorDetails errorDetails=new ErrorDetails();
		errorDetails.setMessage(validationException.getMessage());
		errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
		
		ResponseEntity<ErrorDetails> error = new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
		return error;
	}

}
