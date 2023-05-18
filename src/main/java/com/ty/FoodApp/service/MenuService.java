package com.ty.FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.FoodApp.config.ResponseStructure;
import com.ty.FoodApp.dao.MenuDao;
import com.ty.FoodApp.dto.Menu;
import com.ty.FoodApp.dto.User;
import com.ty.FoodApp.exception.UserIdNotFoundException;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucessfully updated");
		responseStructure.setData(dao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu) {
		Menu menu2 = dao.saveMenu(menu);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		if (menu2 != null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Sucessfully updated");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
		} else {
			throw new UserIdNotFoundException("Menu id is not found");
		}
	}
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int mid) {
		Menu menu = dao.deleteMenu(mid);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully deleted");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);

		} else {
			throw new UserIdNotFoundException("Menu id is not found");
		}
		
	}
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int mid) {
		Menu menu = dao.getMenuByIdMenu(mid);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessfully found");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new UserIdNotFoundException("Menu id is not found");
		}
	}
}
