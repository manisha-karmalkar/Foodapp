package com.ty.FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.FoodApp.dto.Menu;
import com.ty.FoodApp.repo.MenuRepo;

@Repository
public class MenuDao {
	
	@Autowired
	private MenuRepo repo;
	
	public Menu saveMenu(Menu menu) {
		return repo.save(menu);
	}
	public Menu updateMenu(int mid,Menu menu) {
	   Optional<Menu> menu2=repo.findById(mid);
	   if(menu2.isPresent()) {
		   menu.setMid(mid);
		   repo.save(menu);
		   return menu2.get();
	   }else {
		   return null;
	   }	
	}
	public Menu deleteMenu(int mid) {
	Optional<Menu> menu=repo.findById(mid);
	if(menu!=null) {
		repo.deleteById(mid);
		return menu.get();
	}else
		return null;
	}
	public Menu getMenuByIdMenu(int mid) {
		Optional<Menu> menu=repo.findById(mid);
		if(menu!=null) {
			return menu.get();
		}else
			return null;
	}
}
