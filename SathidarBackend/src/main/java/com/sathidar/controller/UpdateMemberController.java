package com.sathidar.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sathidar.EntityMangerFactory.UpdateMemberEntityMangerFactory;
import com.sathidar.model.UpdateMember;
import com.sathidar.model.User;
import com.sathidar.service.UpdateMemberService;

@RestController
@RequestMapping("/api")
public class UpdateMemberController {

	@Autowired
	private UpdateMemberService updateMemberService;
	
	@Autowired
	private UpdateMemberEntityMangerFactory updateMemberEntityMangerFactory;
	
	@PostMapping(path = "/member/update/{id}")
	public Map<String, String> updateMember(@Validated @RequestBody UpdateMember updateMember,@PathVariable("id") int id) {
		  HashMap<String, String> map = new HashMap<>();
		if(updateMemberService.UpdateMemberDetails(updateMember,id) !=null) {
			 map.put("message", "Member Updated...");
		}else {
			map.put("message", "Something wrong , please try again....");
		}
		return map;
	}
	
	@GetMapping(value = "/member/get-details/{id}")
	public UpdateMember getAllUsers(@PathVariable("id") int id) {
		return updateMemberService.getMemberDetails(id);
	}
	
	@GetMapping(value = "/member/get-details-by-member-id/{member_number}")
	public UpdateMember getDetailsByMemberID(@PathVariable("member_number") String member_number) {
		return updateMemberService.getDetailsByMemberID(member_number);
	}
}
