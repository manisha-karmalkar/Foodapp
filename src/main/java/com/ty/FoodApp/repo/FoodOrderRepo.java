package com.ty.FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.FoodApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer> {

}
