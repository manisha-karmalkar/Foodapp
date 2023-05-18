 package com.ty.FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.FoodApp.dto.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
