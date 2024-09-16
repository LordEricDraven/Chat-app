package com.coderscampus.assignment14.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.domain.User;

@Repository
public class UserRepository {

	private Map<Long, User> users = new HashMap<>();
	
	public void addUser(User user) {
		users.put(user.getUserId(), user);
	}
	
	public User getUserById(Long userId) {
		return users.get(userId);
	}
	
	public User getUserbyUsername(String username) {
		return users.values()
					.stream()
					.filter(user -> username.equals(user.getUsername()))
					.findFirst()
					.orElse(null);
	}
	
	public boolean userExists(Long userId) {
		return users.containsKey(userId);
	}
	
	public void removeUser(Long userId) {
		users.remove(userId);
	}
}
