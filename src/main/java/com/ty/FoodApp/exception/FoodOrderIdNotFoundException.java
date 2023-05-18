package com.ty.FoodApp.exception;

public class FoodOrderIdNotFoundException extends RuntimeException{
	
	private String message="id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public FoodOrderIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	

}
