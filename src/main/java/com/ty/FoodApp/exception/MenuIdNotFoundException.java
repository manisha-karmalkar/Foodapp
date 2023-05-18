package com.ty.FoodApp.exception;

public class MenuIdNotFoundException extends RuntimeException {
	
	private String message="id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public MenuIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	

}
