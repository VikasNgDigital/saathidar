package com.sathidar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UpdateMember {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String membernative;
	
	private Double height;
	
	private Double weight;
	
	private String lifestyles;
	
	private String known_languages;
	
	private String education;
	
	private String job;
	
	private String income;
	
	private String hobbies;
	
	private String expectations;

	private String first_name;
	
	private String last_name;
	
	private String gender;
	
	private Integer age;
	
	private String marital_status;
	
	private String contact_number;
	
	private String email_id;
	
	private String profilecreatedby;
	
	private Integer cast_id;
	
	private Integer subcaste_id;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMembernative() {
		return membernative;
	}

	public void setMembernative(String membernative) {
		this.membernative = membernative;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getLifestyles() {
		return lifestyles;
	}

	public void setLifestyles(String lifestyles) {
		this.lifestyles = lifestyles;
	}

	public String getKnown_languages() {
		return known_languages;
	}

	public void setKnown_languages(String known_languages) {
		this.known_languages = known_languages;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getExpectations() {
		return expectations;
	}

	public void setExpectations(String expectations) {
		this.expectations = expectations;
	}

	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getProfilecreatedby() {
		return profilecreatedby;
	}

	public void setProfilecreatedby(String profilecreatedby) {
		this.profilecreatedby = profilecreatedby;
	}

	public Integer getCast_id() {
		return cast_id;
	}

	public void setCast_id(Integer cast_id) {
		this.cast_id = cast_id;
	}

	public Integer getSubcaste_id() {
		return subcaste_id;
	}

	public void setSubcaste_id(Integer subcaste_id) {
		this.subcaste_id = subcaste_id;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UpdateMember(Integer id, String membernative, Double height, Double weight, String lifestyles,
			String known_languages, String education, String job, String income, String hobbies, String expectations,
			String first_name, String last_name, String gender, Integer age, String marital_status, String contact_number,
			String email_id, String profilecreatedby, Integer cast_id, Integer subcaste_id) {
		super();
		this.id = id;
		this.membernative = membernative;
		this.height = height;
		this.weight = weight;
		this.lifestyles = lifestyles;
		this.known_languages = known_languages;
		this.education = education;
		this.job = job;
		this.income = income;
		this.hobbies = hobbies;
		this.expectations = expectations;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.age= age;
		this.marital_status = marital_status;
		this.contact_number = contact_number;
		this.email_id = email_id;
		this.profilecreatedby = profilecreatedby;
		this.cast_id = cast_id;
		this.subcaste_id = subcaste_id;
	}

	public UpdateMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
