package com.sit.trading.ServiceIMPL;

import com.sit.trading.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import com.sit.homeloan.repository.UserRepository;
import com.sit.trading.Services.UserDetailsService;

public class CustomeUserDetailsService  implements UserDetailsService{

	 @Autowired
	 private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		User user= userRepository.findByEmail(username);
		
		if(user==null) {
			
		}
		return null;
	}

	
	
}
