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

import com.ty.FoodApp.config.ResponseStructure;
import com.ty.FoodApp.dto.FoodOrder;
import com.ty.FoodApp.service.FoodOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FoodOrderController {

	@Autowired
	private FoodOrderService service;
	
	@ApiOperation(value = "Save Food Oreder",notes = "Api is used to save Food Order")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Food order saved"),
	@ApiResponse(code = 400,message ="Food order id is not found for given id" )})
	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> savFoodOrder(@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}
	
	@ApiOperation(value = "Update Food Oreder",notes = "Api is used to update Food Order")
	@ApiResponses(value = {@ApiResponse(code=201,message = "Food order updated"),
	@ApiResponse(code = 404,message ="Food order id is not found for given id" )})
	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int id) {
		return service.updateFoodOrder(foodOrder, id);
	}
	
	@ApiOperation(value = "Delete Food Oreder",notes = "Api is used to delete Food Order")
	@ApiResponses(value = {@ApiResponse(code=201,message = "Food order deleted"),
	@ApiResponse(code = 404,message ="Food order id is not found for given id" )})
	@DeleteMapping("/deleteFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int id) {
		return service.deleteFoodOreder(id);
		
	}
	
	@ApiOperation(value = "Get Food Oreder by id",notes = "Api is used to get Food Order by id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "Food order saved"),
	@ApiResponse(code = 404,message ="Food order id is not found for given id" )})
	@GetMapping("/getFoodOrderById")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrder(@RequestParam int id) {
		return service.getItemsById(id);
		
	}
}
