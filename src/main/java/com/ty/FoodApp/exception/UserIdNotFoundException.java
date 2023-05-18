package com.ty.FoodApp.exception;

public class UserIdNotFoundException extends RuntimeException {
	
	private String message="id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public UserIdNotFoundException(String message) {
		super();
		this.message = message;
	}


}
