package edu.ccsu.sped.workflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccsu.sped.workflow.dto.UserAuthorities;
import edu.ccsu.sped.workflow.repos.UserAuthoritiesRepository;


@Service
public class UserAuthoritiesService {

	@Autowired
	private UserAuthoritiesRepository userAuthoritiesRepository;
	
	// GET all 
		public List<UserAuthorities> getUserAuthorities() {
			return (List<UserAuthorities>) userAuthoritiesRepository.findAll();
		}
	
	// GET single instance
	public Optional<UserAuthorities> getUserAuthoritiesById(Integer Id) {
		return userAuthoritiesRepository.findById(Id);
	}
	
	// POST new instance
	public void addUserAuthorities(UserAuthorities userAuthorities) {
		userAuthoritiesRepository.save(userAuthorities);
	}
	
	// PUT single existing instance to update
	public void updateUserAuthorities(UserAuthorities userAuthorities) {
		userAuthoritiesRepository.save(userAuthorities);
	}
	
	// DELETE single instance
	public void deleteUserAuthoritiesById(Integer Id) {
		userAuthoritiesRepository.deleteById(Id);
	}
	
	public void saveAll(List<UserAuthorities> userAuthorities) {
		
		for(UserAuthorities userAuthority : userAuthorities) {
			userAuthoritiesRepository.save(userAuthority);
		}
	}
}