package com.ty.FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.FoodApp.dto.FoodOrder;
import com.ty.FoodApp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {
	
	@Autowired
	private FoodOrderRepo repo;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return repo.save(foodOrder);
	}
	public FoodOrder updateFoodOrder(FoodOrder foodOrder,int id) {
		Optional<FoodOrder> foodOrder2=repo.findById(id);
		if(foodOrder2.isPresent()) {
			foodOrder.setFid(id);
			foodOrder.setItems(foodOrder.getItems());
			return foodOrder2.get();
		}else
			return null;
	}
	public FoodOrder getFoodOrder(int id) {
		Optional<FoodOrder> foodOrder=repo.findById(id);
		if(foodOrder.isPresent()) {
			return foodOrder.get();
		}else
			return null;
	}
	public FoodOrder deleteFoodOrder(int id) {
		Optional<FoodOrder> foodOrder=repo.findById(id);
		if(foodOrder.isPresent()) {
			repo.deleteById(id);
			return foodOrder.get();
		}else {
			return null;
		}
		
	}

}
