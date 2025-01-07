package com.jsp.bank_management_system.exception;

public class CustomerIdNotFound extends RuntimeException{
	private String message = "id not found";

	public String getMessage() {
		return message;
	}
}
