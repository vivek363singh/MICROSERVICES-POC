package com.example.userservice.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception e, WebRequest webRequest){
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), e.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>( errorMessage, HttpStatus.NOT_FOUND);
	}
}
