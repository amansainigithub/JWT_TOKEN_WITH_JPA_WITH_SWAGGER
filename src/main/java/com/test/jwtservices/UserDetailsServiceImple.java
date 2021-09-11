package com.test.jwtservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.config.JwtTokenUtil;
import com.test.model.User;
import com.test.services.UserServices;

@Configuration
public class UserDetailsServiceImple implements UserDetailsService  {

	@Autowired
	private UserServices userServices;
	
	
	
 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userServices.getUser(username);
		
		if(user == null)
		{
			throw new UsernameNotFoundException("Bad Credientials");
		}
		else
		{
			 
			return new CustomUserDetails(user);
		
		}
	}

}
