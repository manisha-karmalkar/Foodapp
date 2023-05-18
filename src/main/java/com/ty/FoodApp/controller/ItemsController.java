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
import com.ty.FoodApp.dto.Items;
import com.ty.FoodApp.dto.User;
import com.ty.FoodApp.service.ItemsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemsController {
	
	@Autowired
	private ItemsService service;
	
	@ApiOperation(value = "Save Items",notes = "Api is used to save items")
	@ApiResponses(value = {@ApiResponse(code=200,message = "Items saved"),
	@ApiResponse(code = 404,message ="Items id is not found for given id" )})
	@PostMapping("/saveItems")
	public ResponseEntity<ResponseStructure<Items>>  saveItems(@RequestBody Items items) {
		return service.saveItems(items);
	}
	
	@ApiOperation(value = "Update Items",notes = "Api is used to update items")
	@ApiResponses(value = {@ApiResponse(code=201,message = "Items updated"),
	@ApiResponse(code = 404,message ="Items id is not found for given id" )})
	@PutMapping("/updateItems")
	public ResponseEntity<ResponseStructure<Items>> updateItems(@RequestParam int id ,@RequestBody Items items) {
		return service.updateItems(items);
	}
	
	@ApiOperation(value = "Delete Items",notes = "Api is used to delete items")
	@ApiResponses(value = {@ApiResponse(code=201,message = "Items deleted"),
	@ApiResponse(code = 404,message ="Items id is not found for given id" )})
	@DeleteMapping("/deleteItems")
	public ResponseEntity<ResponseStructure<Items>> deleteItems(@RequestParam int id) {
		return service.deleteItems(id);
	}
	
	@ApiOperation(value = "Get Items By Id",notes = "Api is used to get items by id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "items found"),
	@ApiResponse(code = 404,message ="Items not found for given id" )})
	@GetMapping("/getItemsById")
	public ResponseEntity<ResponseStructure<Items>> geItemsById(@RequestParam int id) {
		return service.getItemsById(id);
	}

}
