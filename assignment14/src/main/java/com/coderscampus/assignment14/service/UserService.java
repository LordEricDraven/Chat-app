package com.coderscampus.assignment14.service;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.UserRepository;

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
	
	public User getUserByUsername(String username) {
		return userRepo.getUserbyUsername(username);
	}
	
	public boolean userExists(Long userId) {
		return userRepo.userExists(userId);
	}

	private Long generateUniqueId() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}
	
}
