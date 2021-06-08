package com.bridgelabz.userregisteration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class UserException extends RuntimeException {

	
	private static final long serialVersionUID = 7651517566644148130L;

	private int statusCode;
	
	private String statusMessage;
}
