package com.coderscampus.assignment14.service;

import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User createUser(String username) {
		Long userId = generateUniqueId();
		User user = new User(username, userId);
		userRepo.addUser(user);
		return user;
	}
	
	public User getUserById(Long userId) {
		return userRepo.getUserById(userId);
	}

	private Long generateUniqueId() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}
	
}
