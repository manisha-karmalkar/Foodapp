package com.ty.FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.FoodApp.config.ResponseStructure;
import com.ty.FoodApp.dto.Menu;
import com.ty.FoodApp.service.MenuService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MenuController {

	@Autowired
	private MenuService service;
	
	@ApiOperation(value = "Save Menu",notes = "Api is used to save Menu")
	@ApiResponses(value = {@ApiResponse(code=200,message = "product saved"),
	@ApiResponse(code = 400,message ="Menu id is not found for given id" )})
	@PostMapping("/saveMenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}
	@ApiOperation(value = "Update Menu",notes = "Api is used to update Menu")
	@ApiResponses(value = {@ApiResponse(code=201,message = "Menu updated"),
	@ApiResponse(code = 404,message ="Menu id is not found for given id" )})
	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int mid,@RequestBody Menu menu) {
		return service.updateMenu(menu);
	}
	@ApiOperation(value = "delete Menu",notes = "Api is used to delete Menu")
	@ApiResponses(value = {@ApiResponse(code=201,message = "Menu deleted"),
	@ApiResponse(code = 404,message ="Menu id is not found for given id" )})
	@DeleteMapping("/deleteMenu")
	public ResponseEntity<ResponseStructure<Menu>> deletemenu(@RequestParam int mid) {
		return service.deleteMenu(mid);
	}
	@ApiOperation(value = "Get Menu By Id",notes = "Api is used to get Menu by id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "Menu updated"),
	@ApiResponse(code = 404,message ="Menu id is not found for given id" )})
	@GetMapping("/getMenuById")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int mid) {
		return service.getMenuById(mid);
	}
}
