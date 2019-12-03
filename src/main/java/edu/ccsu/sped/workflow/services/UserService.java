package edu.ccsu.sped.workflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccsu.sped.workflow.dto.User;
import edu.ccsu.sped.workflow.repos.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	// GET all 
	public List<User> getUsers() {
		return new ArrayList<>(userRepository.findAll());
	}
	
	// GET single instance
	public Optional<User> getUserById(Integer Id) {
		return userRepository.findById(Id);
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	// POST new instance
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	// PUT single existing instance to update
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	// DELETE single instance
	public void deleteUserById(Integer Id) {
		userRepository.deleteById(Id);
	}
	
	public void saveAll(List<User> users) {
		
		for(User user : users) {
			userRepository.save(user);
		}
	}
	
	
}

