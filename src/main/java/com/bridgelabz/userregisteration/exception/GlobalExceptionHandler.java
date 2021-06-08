package com.bridgelabz.userregisteration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.userregisteration.response.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Response> handleUserException(UserException exception){
		
		Response response = new Response(exception.getStatusCode(), exception.getStatusMessage(), null);
		
		return new ResponseEntity<Response>(response,HttpStatus.BAD_GATEWAY); 
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception exception){
		
		exception.printStackTrace();
		Response response = new Response(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), null);
		
		return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST); 
	}
}
