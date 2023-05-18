package com.ty.FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.FoodApp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer>{

}
