package com.sit.trading.Services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.sit.homeloan.repository.UserRepository;
//
//public class CustomeUserDetailsService {
//   
//	 @Autowired
//	 private UserRepository userRepository;
//	 
//	 
//} 


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sit.homeloan.repository.UserRepository;
import com.sit.trading.model.User;

@Service

public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + email);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}
