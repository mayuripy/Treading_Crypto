package com.sit.trading.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.sit.trading.Enums.User_Role;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  
	private String password;
	
	@Embedded
	private TwoFactoreAuto twofactoreauto =new TwoFactoreAuto();
	private User_Role role=User_Role.ROLE_CUSTOMER;
	
	
	
	

}
