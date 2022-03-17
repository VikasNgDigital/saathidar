package com.sathidar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sathidar.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  { 

	User findByUsername(String username);
	
	User findByConfirmationToken(String confirmationToken);
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
}
