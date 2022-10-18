package com.javatpoint.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.user.model.User;
import com.javatpoint.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}

	public void update(User user, int userid) {
		userRepository.save(user);
	}
}
