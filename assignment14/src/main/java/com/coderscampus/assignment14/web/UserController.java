package com.coderscampus.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/create")
	@ResponseBody
	public User createUser(@RequestParam String username) {
		return userService.createUser(username); 
	}
//	
//	@GetMapping("/{username}")
//	@ResponseBody
//	public User getUserByUsername(@PathVariable String username) {
//		return userService.getUserByUsername(username);
//	}
//	
//	@GetMapping("/exists/{userId}")
//	@ResponseBody
//	public boolean userExists(@PathVariable Long userId) {
//		return userService.userExists(userId);
//	}
	
	//user doesn't need a dedicated page for this assignment.
	@GetMapping
	public String showUserPage() {
		return "user";
	}
	
}
