package com.example.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
@Repository
public interface UserRespository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsernameAndPassword(String username, String password);
	   User findByUsername(String username);
}
