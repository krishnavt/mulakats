package com.mulakat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mulakat.entity.Blog;
import com.mulakat.entity.Item;
import com.mulakat.entity.Role;
import com.mulakat.entity.User;
import com.mulakat.repository.BlogRepository;
import com.mulakat.repository.ItemRepository;
import com.mulakat.repository.RoleRepository;
import com.mulakat.repository.UserRepository;

@Service
public class InitDBService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private BlogRepository blogRepository;

	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);

		Blog blogJavaVids = new Blog();
		blogJavaVids.setName("JavaVids");
		blogJavaVids.setUrl("http://feeds.feedburner.com/javavids");
		blogJavaVids.setUser(userAdmin);

		blogRepository.save(blogJavaVids);

		Item item = new Item();
		item.setBlog(blogJavaVids);
		item.setTitle("first");
		item.setLink("http://www.javavids.com");
		item.setDescription("Java Videos");
		item.setPublishedDate(new Date());

		itemRepository.save(item);

		Item item2 = new Item();
		item2.setBlog(blogJavaVids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setDescription("Java Videos");
		item2.setPublishedDate(new Date());

		itemRepository.save(item2);
	}
}
