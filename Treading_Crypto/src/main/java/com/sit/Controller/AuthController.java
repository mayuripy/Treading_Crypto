package com.sit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.Repository.UserRepository;
import com.sit.model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {
   
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
