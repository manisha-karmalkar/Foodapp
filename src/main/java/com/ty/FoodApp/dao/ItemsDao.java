package com.ty.FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.FoodApp.dto.Items;
import com.ty.FoodApp.repo.ItemsRepo;

@Repository
public class ItemsDao {
	
	@Autowired
	private ItemsRepo repo;
	
	public Items saveItems(Items items) {
		return repo.save(items);
	}
	
	public Items updateItems(int id,Items items) {
		Optional<Items> items2=repo.findById(id);
		if(items2.isPresent()) {
			items.setItem_id(id);
			repo.save(items);
			return items2.get();
		}else
		return null;
	}
	public Items deleteItems(int id) {
		Optional<Items> items=repo.findById(id);
		if(items.isPresent()) {
			repo.deleteById(id);
			return items.get();
		}else
		return null;
	}

	public Items getItemsById(int id) {
		Optional<Items> items=repo.findById(id);
		if(items!=null) {
			return items.get();
		}else
		return null;
	}

}
