package edu.ccsu.sped.workflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccsu.sped.workflow.dto.LoginData;
import edu.ccsu.sped.workflow.dto.User;
import edu.ccsu.sped.workflow.dto.Workflow;
import edu.ccsu.sped.workflow.repos.LoginDataRepository;
import edu.ccsu.sped.workflow.repos.UserRepository;

@Service
public class LoginDataService {

	@Autowired
	private LoginDataRepository loginDataRepository;
	
	// GET all 
		public List<LoginData> getLoginDatas() {
			return (List<LoginData>) loginDataRepository.findAll();
		}
	
	// GET single instance
	public Optional<LoginData> getLoginDataById(Integer Id) {
		return loginDataRepository.findById(Id);
	}
	
	public LoginData getLoginDataByUser(User user) {
		return loginDataRepository.findLoginDataByUser_Uid(user.getUid());
	}
	
	// POST new instance
	public void addLoginData(LoginData loginData) {
		loginDataRepository.save(loginData);
	}
	
	// PUT single existing instance to update
	public void updateLoginData(LoginData loginData) {
		loginDataRepository.save(loginData);
	}
	
	// DELETE single instance
	public void deleteLoginDataById(Integer Id) {
		loginDataRepository.deleteById(Id);
	}
	
	public void saveAll(List<LoginData> loginDatas) {
		
		for(LoginData loginData : loginDatas) {
			loginDataRepository.save(loginData);
		}
	}
}