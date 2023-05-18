package com.ty.FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.FoodApp.config.ResponseStructure;
import com.ty.FoodApp.dao.FoodOrderDao;
import com.ty.FoodApp.dto.FoodOrder;
import com.ty.FoodApp.dto.Items;
import com.ty.FoodApp.exception.UserIdNotFoundException;

@Service
public class FoodOrderService {
	
	@Autowired
	private FoodOrderDao dao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodorder) {
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		List<Items> list=foodorder.getItems();
		double totalprice=0;
		for(Items items:list) {
			totalprice+=items.getCost()*items.getQuantity();
			foodorder.setTotalprice(totalprice);
		}
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully created");
		responseStructure.setData(dao.saveFoodOrder(foodorder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder,int id) {
		FoodOrder foodOrder2=dao.getFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();	
		if(foodOrder2!=null) {
			List<Items> list=foodOrder2.getItems();
			double totalprice=0;
			for(Items items:list) {
				totalprice+=items.getCost()*items.getQuantity();
				foodOrder.setTotalprice(totalprice);
			}
			foodOrder.setTotalprice(totalprice);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("sucessfully updated");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);
		}else 
			throw new UserIdNotFoundException("FoodOrder id is not found");
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOreder(int id) {
		FoodOrder foodOrder=dao.deleteFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();

		if(foodOrder!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully updated");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		}else
			throw new UserIdNotFoundException("FoodOrder id is not found");
		
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> getItemsById(int id) {
		FoodOrder foodOrder=dao.getFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		if(foodOrder!=null) {
			List<Items> list=foodOrder.getItems();
			double totalprice=0;
			for(Items items:list) {
				totalprice+=items.getCost()*items.getQuantity();
				foodOrder.setTotalprice(totalprice);
			}
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully updated");
			responseStructure.setData(foodOrder);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.FOUND);
		}else
			throw new UserIdNotFoundException("FoodOrder id is not found");
		
	}

}
