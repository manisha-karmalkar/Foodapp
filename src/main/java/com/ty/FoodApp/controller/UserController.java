package com.ty.FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.ty.FoodApp.config.ResponseStructure;
import com.ty.FoodApp.dto.User;
import com.ty.FoodApp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@ApiOperation(value = "Save User",notes = "API is used to save user for given user id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "sucessfully saved"),
	      @ApiResponse(code = 400,message = "id not found for the given user")})
	
	@PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@ApiOperation(value = "Update User",notes = "API is used to update API")
	@ApiResponses(value = {@ApiResponse(code = 201,message ="sucessfully updated"),
			@ApiResponse(code = 404,message = "user not found")})
	@PutMapping("/updateuser")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int id,@RequestBody User user) {
		return service.updateUser(id, user);
	}
	
	@ApiOperation(value = "Delete User",notes = "Api is used t delete user for  the given user id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "sucessfully deleted"),
	      @ApiResponse(code = 404,message = "user not found for given user id")})
	@DeleteMapping("/deleteuser")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id) {
		return service.daleteUser(id);
	}
	
	@ApiOperation(value = "Get User by id",notes = "Api is used to get usesr by given id")
	@ApiResponses(value= {@ApiResponse(code = 302,message = "User id is found"),
			@ApiResponse(code = 404,message = "user id not found for given id")})
	@GetMapping("/getuserbyid")
	public ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam int id) {
		return service.getUserById(id);
	}
}
