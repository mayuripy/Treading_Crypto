package com.sit.trading.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sit.trading.Enums.User_Role;
import com.sit.trading.domain.USER_ROLE;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Fullname;
    private String email;
    
    @JsonProperty(access =JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @Embedded
    private TwoFactoreAuth twofactoreAuth=new TwoFactoreAuth();

    
    private User_Role role= User_Role.ROLE_CUSTOMER;
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
	public String setFullname() {
		return Fullname;
	}
}
