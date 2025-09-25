package com.sit.trading.ServiceIMPL;

import com.sit.trading.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sit.homeloan.repository.UserRepository;
import com.sit.trading.Services.UserDetailsService;


@Service
public class CustomeUserDetailsService  implements org.springframework.security.core.userdetails.UserDetailsService{

	 @Autowired
	 private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		Object user= userRepository.findByEmail(username);
		
		if(user==null) {
			
		}
		return null;
	}

	
	
}
