package com.sit.trading.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.trading.Repository.UserRepository;
import com.sit.trading.model.User;

@RestController
@RequestMapping("/auth")
public class mainAuthController {
   
	 @Autowired
	 private UserRepository userRepository;
	 
	 @PostMapping("/signUp")
	 public ResponseEntity<User> register(User user){
		  
		 User newUser=new User();
		 newUser.setFullName(user.getFullName());
		 newUser.setEmail(user.getEmail());
		 newUser.setPassword(user.getPassword());
		 
		 User saveUser=userRepository.save(newUser);
		  return new ResponseEntity<> (saveUser,HttpStatus.CREATED);	
		 
	 }
}
