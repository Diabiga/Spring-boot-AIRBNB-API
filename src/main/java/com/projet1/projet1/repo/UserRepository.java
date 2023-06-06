package com.projet1.projet1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet1.projet1.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	//User findByUsername(String username);
}
