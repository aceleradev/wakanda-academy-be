package com.aceleradev.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aceleradev.api.domain.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	@Query("SELECT u FROM User u JOIN FETCH u.credential c WHERE c.email = ?1 AND c.password = ?2")
	Optional<User> findByUsernameAndPassword(String username, String password);
	
	@Query("SELECT u FROM User u JOIN FETCH u.credential c WHERE c.email = ?1")
	Optional<User> findByEmail(String email);
	
}
