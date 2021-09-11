package com.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.User;
import com.test.services.UserServices;

@RestController
@CrossOrigin("*")
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserServices userServices; 
	
	@RequestMapping("/saveUser")
	public ResponseEntity<User> home()
	{
		User user=new User(2, "aman", this.bCryptPasswordEncoder.encode("aman123"), "ADMIN");
		
		this.userServices.saveUser(user);
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/welcome")
	public String welcome()
	{
		
	return "welcome API";
	}
	
	@GetMapping("/test")
	public String teeest()
	{
		
	return "Testing successI";
	}

}
