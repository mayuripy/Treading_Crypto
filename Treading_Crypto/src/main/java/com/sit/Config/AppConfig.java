package com.sit.Config;


import jakarta.servlet.Filter;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppConfig {
  
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.sessionManagement(managment ->managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
		authorizeHttpRequests(Authorizae->Authorizae.requestMatchers("/api/**").authenticated().anyRequest().permitAll())
				.addFilterBefore(new JWtTokenValidatore(), BasicAuthenticationFilter.class)
				.csrf(csrf->csrf.disable())
				.cors(cors->cors.ConfigurationSource(corsConfigrationSource()));
		
		return null;
	}
	
	private ConfigurationSource corsConfigrationSource() {
		
		return null;
	}
	 
}
