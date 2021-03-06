package com.mulakat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.mulakat.entity.Blog;
import com.mulakat.entity.User;
import com.mulakat.repository.BlogRepository;
import com.mulakat.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);

	}

	public void delete(int id) {
		blogRepository.delete(id);
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}
	@PreAuthorize("#blog.user.name==authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		blogRepository.delete(blog);
	}
}
