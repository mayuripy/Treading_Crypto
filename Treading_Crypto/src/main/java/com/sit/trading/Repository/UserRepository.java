package com.sit.trading.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sit.trading.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     
   // User findByemail(String email);
	Optional<User> findByEmail(String email);
}
