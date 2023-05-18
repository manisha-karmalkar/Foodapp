package com.ty.FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.FoodApp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
