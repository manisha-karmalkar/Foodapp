package com.ty.FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.FoodApp.config.ResponseStructure;
import com.ty.FoodApp.dao.ItemsDao;
import com.ty.FoodApp.dto.Items;
import com.ty.FoodApp.dto.Menu;
import com.ty.FoodApp.exception.UserIdNotFoundException;

@Service
public class ItemsService {
	
	@Autowired
	private ItemsDao dao;
	
	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully created");
		responseStructure.setData(dao.saveItems(items));
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items) {
		Items items2=dao.saveItems(items);
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		if(items2!=null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("sucessfully Updated");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.CREATED);
		}else
			throw new UserIdNotFoundException("Item id is not found");
	}

	public ResponseEntity<ResponseStructure<Items>> deleteItems(int id) {
		Items items=dao.deleteItems(id);
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		if(items!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully deleted");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		}else
			throw new UserIdNotFoundException("Item id is not found");
	}

	public ResponseEntity<ResponseStructure<Items>> getItemsById(int id) {
		Items items=dao.getItemsById(id);
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		if(items!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully found");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.FOUND);
		}else
			throw new UserIdNotFoundException("Item id is not found");
	}
}
