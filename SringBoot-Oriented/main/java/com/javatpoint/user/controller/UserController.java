package com.javatpoint.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.user.model.User;
import com.javatpoint.user.service.UserService;


@RestController
public class UserController {
	
	@GetMapping
	public String messgetoueser() {
		return "this is working";
	}
	

	@Autowired
	UserService userService;

	@GetMapping("/user")
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}

	@GetMapping("/user/{userid}")
	private User getUser(@PathVariable("userid") int userid) {
		return userService.getUserById(userid);
	}

	@DeleteMapping("/user/delete/{userid}")
	private void deleteBook(@PathVariable("userid") int userid) {
		userService.delete(userid);
	}

	@PostMapping("/user/post")
	private int saveUser(@RequestBody User user) {
		userService.saveOrUpdate(user);
		return user.getId();
	}

	@PutMapping("/user/put")
	private User update(@RequestBody User user) {
		userService.saveOrUpdate(user);
		return user;
	}
}
