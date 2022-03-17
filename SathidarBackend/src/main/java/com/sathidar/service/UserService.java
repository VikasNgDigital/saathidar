package com.sathidar.service;

import com.sathidar.model.User;

import antlr.collections.List;

public interface UserService {

	java.util.List<User> getAllUsers();
	
	boolean registerUser(User user);
	
	User resetUser(User user);
	
	User changeUserPassword(User user);
	
	User confirmrUser(String token);
	
	User loginUser(User user);

	String generatePassword(int length);
	
//	User logoutUser(User user);
}
