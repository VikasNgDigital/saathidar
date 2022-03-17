package com.sathidar.controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sathidar.EntityMangerFactory.UserEntityManagerFactory;
import com.sathidar.model.User;
//import com.sathidar.service.EmailService;
import com.sathidar.service.UserService;


//@CrossOrigin(maxAge = 3600) // https://spring.io/guides/gs/rest-service-cors/
@CrossOrigin(origins = "http://localhost:9092")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserEntityManagerFactory userEntityManagerFactory;
	
	
//	@Autowired
//	private EmailService emailService;
	
//	@Value("${webServerUrl}")
//	private String webServerUrl;
	
	
//	@GetMapping(path = "/users")
	@RequestMapping(value = "/users",produces = "application/json",method=RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping(path = "/users/register")
	public void register(@Validated @RequestBody User user) {
		boolean status=false;
		if (userService.registerUser(user)) {
			int getRoleID=userEntityManagerFactory.getRoleID(user.getRole());
			if(getRoleID==1) {				
				int getLastInsertedID=userEntityManagerFactory.getLastInsertedID();
				if(userEntityManagerFactory.saveRoleToMember(getRoleID, getLastInsertedID)) {
//					SimpleMailMessage registrationEmail = new SimpleMailMessage();
//					registrationEmail.setTo(user.getEmail());
//					registrationEmail.setSubject("Registration Confirmation");
//					registrationEmail.setText("To confirm your e-mail address, please click the link below:\n" + webServerUrl
//							+ "/users/confirm?token=" + user.getConfirmationToken());
//					registrationEmail.setFrom("noreply@domain.com");
//					emailService.sendEmail(registrationEmail);
					status=true;
				}
			}
		}
	}

	@GetMapping(path = "/users/confirm")
	public String confirm(@RequestParam("token") String token) {
		userService.confirmrUser(token);
		return "User confirmed.";
	}

	@PostMapping(path = "/users/login")
	public User login(@Validated @RequestBody User user) {
		
		return userService.loginUser(user);
	}
	
//	@PostMapping(path = "/users/logout")
//	public User logout(@Validated @RequestBody User user) {
//		return userService.logoutUser(user);
//	}

	@PostMapping(path = "/users/reset")
	public void reset(@Validated @RequestBody User user) {
		User resetUser = userService.resetUser(user);
		if (resetUser != null) {
//			SimpleMailMessage registrationEmail = new SimpleMailMessage();
//			registrationEmail.setTo(user.getEmail());
//			registrationEmail.setSubject("Temporary Password Sent From " + webServerUrl);
//			registrationEmail
//					.setText("To access your account, please use this temporary password:  " + resetUser.getPassword()
//							+ ".\r\nNOTE: This email was sent from an automated system. Please do not reply.");
//			registrationEmail.setFrom("noreply@domain.com");
//			emailService.sendEmail(registrationEmail);
		}
	}

	@PostMapping(path = "/users/changepwd")
	public User changePassword(@Validated @RequestBody User user) {
		return userService.changeUserPassword(user);
	}
}
