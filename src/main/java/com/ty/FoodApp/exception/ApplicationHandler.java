package com.ty.FoodApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.FoodApp.config.ResponseStructure;

@ControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> UserIdNotFound(UserIdNotFoundException ex) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("user id not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> ProductIdNotFound(ProductIdNotFoundException ex) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("product id not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(MenuIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> MenuIdNotFound(MenuIdNotFoundException ex) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("menu id not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(ItemsIdNotFoundexception.class)
	public ResponseEntity<ResponseStructure<String>> ItemsIdNotFound(ItemsIdNotFoundexception ex) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("Items id not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(FoodOrderIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> FoodOrderIdNotFound(FoodOrderIdNotFoundException ex) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("food order id not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
}
