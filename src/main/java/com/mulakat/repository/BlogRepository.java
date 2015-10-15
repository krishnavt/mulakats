package com.mulakat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mulakat.entity.Blog;
import com.mulakat.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);

}
