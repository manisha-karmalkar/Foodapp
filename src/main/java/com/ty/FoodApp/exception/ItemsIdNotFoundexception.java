package com.ty.FoodApp.exception;

public class ItemsIdNotFoundexception extends RuntimeException{
	
	private String message="id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public ItemsIdNotFoundexception(String message) {
		super();
		this.message = message;
	}
	
	
	

}
