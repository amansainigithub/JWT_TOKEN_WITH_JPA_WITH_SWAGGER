package com.test.user_repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.User;

@Configuration
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	
	public User findByUsername(String username);
	
	
	

}
