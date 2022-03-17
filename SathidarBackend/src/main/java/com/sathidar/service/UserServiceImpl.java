package com.sathidar.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.Session;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.json.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sathidar.EntityMangerFactory.UserEntityManagerFactory;
import com.sathidar.exception.BadRequestException;
import com.sathidar.model.Role;
import com.sathidar.model.User;
import com.sathidar.repository.UserRepository;

@Service
@EnableJpaAuditing
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	
	@Autowired
	private UserEntityManagerFactory userEntityManagerFactory;
	
	
	private static final Random RANDOM = new SecureRandom();
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			user.setPassword("");
		}
		return users;
	}

	@Override
	public boolean registerUser(User user) {
		String password = user.getPassword();
		if (password.isEmpty()) {
			throw new BadRequestException("Invalid password.");
		}

		String encodedPassword = encoder.encode(password);
		user.setPassword(encodedPassword);
		if (user.getUsername().isEmpty()) {
			user.setUsername(user.getEmail());
		}

		User userExists = userRepository.findByUsername(user.getUsername());

		if (userExists != null) {
			throw new BadRequestException(user.getUsername() + " already registered.");
		}

		// Disable user until they click on confirmation link in email
//		user.setEnabled(false);
		user.setEnabled(true);
//		user.setRole("USER");
						
		// Generate random 36-character string token for confirmation link
		user.setConfirmationToken(UUID.randomUUID().toString());

		userRepository.save(user);
		
		return true;
	}

	@Override
	public User resetUser(User user) {
		if (user.getUsername().isEmpty()) {
			user.setUsername(user.getEmail());
		}
		User userExists = userRepository.findByUsername(user.getUsername());

		if (userExists == null) {
			throw new BadRequestException(user.getUsername() + " is not registered.");
		}

		if (userExists.getEmail().isEmpty()) {
			throw new BadRequestException(user.getUsername() + " does not have a valid email address.");
		}

		String password = generatePassword(10);
		String encodedPassword = encoder.encode(password);
		userExists.setPassword(encodedPassword);
		userExists.setTempPassword(true);

		userRepository.save(userExists);

		// return the user with plain password so that we can send it to the user's
		// email.
		userExists.setPassword(password);

		return userExists;
	}

	@Override
	public User changeUserPassword(User user) {
		User userExists = userRepository.findByUsername(user.getUsername());

		if (userExists == null) {
			throw new BadRequestException(user.getUsername() + " is not registered.");
		}

		String oldPassword = user.getPassword();
		if (!encoder.matches(oldPassword, userExists.getPassword())) {
			throw new BadRequestException("Invalid current password.");
		}

		if (!userExists.getEnabled()) {
			throw new BadRequestException("The user is not enabled.");
		}

		String newPassword = user.getConfirmationToken();
		String encodedPassword = encoder.encode(newPassword);
		userExists.setPassword(encodedPassword);
		userExists.setTempPassword(false);

		userRepository.save(userExists);

		userExists.setPassword("");
		userExists.setId(0);
		return userExists;
	}

	@Override
	public User confirmrUser(String token) {
		User user = userRepository.findByConfirmationToken(token);

		if (user == null) {
			throw new BadRequestException("Invalid token.");
		}
		// Token found
		user.setEnabled(true);
		user.setConfirmationToken("");

		// Save user
		userRepository.save(user);
		return user;
	}

	@Override
	public User loginUser(User user) {
		User userExists = userRepository.findByUsername(user.getUsername());
		
		if (userExists == null) {
			throw new BadRequestException("Invalid user name.");
		}

		String password = user.getPassword();
		if (!encoder.matches(password, userExists.getPassword())) {
			throw new BadRequestException("Invalid user name and password combination.");
		}

		if (!userExists.getEnabled()) {
			throw new BadRequestException("The user is not enabled.");
		}
		
		if(userExists.getRole().toString().equals("ADMIN") || userExists.getRole().toString().equals("GUEST")) {
				throw new BadRequestException("The user is not authorized.");
		}
		
		
		
		
		userExists.setPassword("");
		return userExists;
	}

	@Override
	public String generatePassword(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String(returnValue);
	}

//	@Override
//	public User logoutUser(User user) {
//		
//		user.setEnabled(false);
//		user.setConfirmationToken("");
//		user.setFirstName("");
//		user.setLastName("");
//		user.setEmail("");
//		user.setId(0);
//		user.setPassword("");
//		user.setRole("");
//		return user;
//	}

}
