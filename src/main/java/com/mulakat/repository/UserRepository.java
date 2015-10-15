package com.mulakat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mulakat.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
