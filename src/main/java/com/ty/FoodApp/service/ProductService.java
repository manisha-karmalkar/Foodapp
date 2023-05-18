package com.ty.FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.FoodApp.config.ResponseStructure;
import com.ty.FoodApp.dao.ProductDao;
import com.ty.FoodApp.dto.Product;
import com.ty.FoodApp.dto.User;
import com.ty.FoodApp.exception.ProductIdNotFoundException;
import com.ty.FoodApp.exception.UserIdNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucessefully saved");
		responseStructure.setData( productDao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);

	}
	public ResponseEntity<ResponseStructure<Product>> updateProduct(int pid,Product product) {
		Product product2=productDao.updateProduct(pid, product);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		if (product2!=null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Sucessefully updated");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
		}else
			throw new ProductIdNotFoundException("Product id is not found");
	}
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int pid) {
		Product product=productDao.deleteProduct(pid);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		if (product!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessefully deleted");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		}else
			throw new ProductIdNotFoundException("Product id is not found");
	}
	public ResponseEntity<ResponseStructure<Product>> getById(int pid) {
		Product product=productDao.getProductById(pid);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		if (product!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessefully found");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);

		}else
			throw new ProductIdNotFoundException("Product id is not found");
	}
	public ResponseEntity<ResponseStructure<List<Product>>>  getAllProducts(int mid) {
	    List<Product> product=productDao.findAllProducts(mid);
		ResponseStructure<List<Product>> responseStructure=new ResponseStructure<List<Product>>();
		if (product!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessefully found");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.FOUND);

		}else
			throw new ProductIdNotFoundException("Products not found");
	}

}
