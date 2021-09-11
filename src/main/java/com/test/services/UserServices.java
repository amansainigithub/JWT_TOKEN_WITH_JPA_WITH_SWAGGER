package com.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.User;
import com.test.user_repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public User saveUser(User newUser)
	{
		return this.userRepository.save(newUser);
	}
	
	public User getUser(String username)
	{
		return this.userRepository.findByUsername(username);
	}
	

}
