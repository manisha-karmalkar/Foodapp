package com.ty.FoodApp.controller;

import java.util.List;

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
import com.ty.FoodApp.dto.Product;
import com.ty.FoodApp.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@ApiOperation(value = "Save product",notes = "Api is used to save product")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "product saved"),
			@ApiResponse(code = 400,message = "Product id is not found for given id")})
	@PostMapping("/saveProduct")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	@ApiOperation(value = "Update Product",notes = "Api is used to update product")
	@ApiResponses(value = {@ApiResponse(code=201,message = "product update"),
	@ApiResponse(code = 404,message ="Product id is not found for given id" )})
	@PutMapping("/updateProduct")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestParam int pid,@RequestBody Product product) {
		return service.updateProduct(pid, product);
	}
	@ApiOperation(value = "Delete Product",notes = "Api is used to delet product")
	@ApiResponses(value = {@ApiResponse(code=200,message = "product deleted"),
	@ApiResponse(code = 404,message ="Product id is not found for given id" )})
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int pid) {
		return service.deleteProduct(pid);
	}
	@ApiOperation(value = "Get Product By Id",notes = "Api is used to update product")
	@ApiResponses(value = {@ApiResponse(code=302,message = "product id found"),
	@ApiResponse(code = 404,message ="Product id is not found for given id" )})
	@GetMapping("/getByIdProduct")
		public ResponseEntity<ResponseStructure<Product>> getProductById(@RequestParam int pid) {
			return service.getById(pid);
		
	}
	@ApiOperation(value = "Get All Product",notes = "Api is used to get all product")
	@ApiResponses(value = {@ApiResponse(code=302,message = "products found"),
	@ApiResponse(code = 404,message ="Products not found" )})
	@GetMapping("/getAllProduct")
	public ResponseEntity<ResponseStructure<List<Product>>>  getAllProducts(@RequestParam int mid){
		return service.getAllProducts(mid);
	}
	
}
