package com.sathidar.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sathidar.util.SendSMSAction;


//@CrossOrigin(maxAge = 3600) // https://spring.io/guides/gs/rest-service-cors/
@CrossOrigin(origins = "http://localhost:9092")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserEntityManagerFactory userEntityManagerFactory;
	
	@Autowired
	private SendSMSAction sendSMSAction;
	
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
	public Map<String, String> register(@Validated @RequestBody User user) {
		 HashMap<String, String> map = new HashMap<>();		 				 
		if(userService.registerUser(user) !=null) {
			 map.put("message", "Member Register...");
		}else {
			map.put("message", "Something wrong , please try again....");
		}
		return map;
	}

	@PostMapping(path = "/member/otp")
	public Map<String, String> sendOTP(@Validated @RequestBody User user) {
		 HashMap<String, String> map = new HashMap<>();		 			
		 String otp=this.getOTP();
		 String smsMessage="Dear Customer, your OTP for registration is " + otp;
		 String sender="STHDAR";
		 if(!sendSMSAction.SendOtpSms(user.getPhone().trim(),sender,smsMessage).equals("")) {
			 if(userEntityManagerFactory.saveTempOTP(user.getPhone().trim(),otp)) {
				 map.put("message", "OTP Send...");
			 }else {
				 map.put("message", "Something wrong , please try again....");
			 }
		}else {
				map.put("message", "Something wrong , please try again....");
		}
		return map;
	}
	
	@GetMapping(path = "/member/verify/otp")
	public Map<String, String> confirmOTP(@Validated @RequestBody User user) {
		 HashMap<String, String> map = new HashMap<>();		
		 String mOtp=user.getOtp();
		 if(userEntityManagerFactory.verifyMemberOtp(mOtp,user.getPhone())) {
			 map.put("message", "OTP Verify Successfully");
		 }else {
			 map.put("message", "OTP Mismatch");
		 }
		 return map;
	}
	
	private String getOTP() {
		return new DecimalFormat("000000").format(new Random().nextInt(999999));
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
	
	@PostMapping(path = "/admin-login")
	public User adminLogin(@Validated @RequestBody User user) {
		return userService.loginAdmin(user);
	}
	
	@PostMapping(path = "/users/changepwd")
	public User changePassword(@Validated @RequestBody User user) {
		return userService.changeUserPassword(user);
	}

	
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

//	@PostMapping(path = "/users/logout")
//	public User logout(@Validated @RequestBody User user) {
//		return userService.logoutUser(user);
//	}
}
