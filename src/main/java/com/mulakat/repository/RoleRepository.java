package com.mulakat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mulakat.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
