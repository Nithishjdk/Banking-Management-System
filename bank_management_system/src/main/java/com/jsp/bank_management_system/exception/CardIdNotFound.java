package com.jsp.bank_management_system.exception;

public class CardIdNotFound extends RuntimeException{

	private String message = "Id not found";

	public String getMessage() {
		return message;
	}
}
