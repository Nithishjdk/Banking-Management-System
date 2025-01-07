package com.jsp.bank_management_system.exception;

public class AccountIdNotFound extends RuntimeException {

	private String message = "Account Id no found";

	public String getMessage() {
		return message;
	}

}