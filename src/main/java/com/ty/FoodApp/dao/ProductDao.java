package com.ty.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.FoodApp.dto.Menu;
import com.ty.FoodApp.dto.Product;
import com.ty.FoodApp.repo.ProductRepo;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private MenuDao menuDao;
	 
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	public Product updateProduct(int pid,Product product) {
		Optional<Product> product2=repo.findById(pid);
		if(product2.isPresent()) {
			product.setId(pid);
			repo.save(product);
			return product2.get();
		}else
			return null;
		
	}
	public Product deleteProduct(int pid) {
		Optional<Product> product=repo.findById(pid);
		if(product.isPresent()) {
			repo.deleteById(pid);
			return product.get();
		}else
			return null;
	}
	
	public Product getProductById(int pid) {
		Optional<Product> product=repo.findById(pid);
		if(product!=null) {
			return product.get();
		}else
			return null;
	}
	public List<Product> findAllProducts(int mid){
	
		Menu menu=menuDao.getMenuByIdMenu(mid);
			if(menu!=menu) 
				return repo.findAllProduct(mid);
			else 
				return null;	
	}
}
