package com.ty.FoodApp.exception;

public class ProductIdNotFoundException extends RuntimeException{
	
	private String message="id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public ProductIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	

}
