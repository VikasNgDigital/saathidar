package com.sathidar.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sathidar.model.UpdateMember;

@Repository
public interface UpdateMemberRepository extends JpaRepository<UpdateMember, Integer> {

	@Transactional
	@Modifying
	@Query(value = "update memberdetails set  membernative= :mNative, height= :mHeight, weight= :mWeight, lifestyles= :mLifeStyles, "
			+ " known_languages= :mKnown_Languages, education= :mEducation, job= :mJob, income= :mIncome, hobbies= :mHobbies , expectations= :mExpectation where member_id= :id", nativeQuery = true)
	Object UpdateMemberDetails(String mNative, double mHeight, double mWeight, String mLifeStyles,
			String mKnown_Languages, String mEducation, String mJob, String mIncome, String mHobbies,
			String mExpectation, int id);

//	@Query(value = "select md.member_id,first_name,last_name,gender,age,marital_status,contact_number,email_id,profilecreatedby,cast_id, subcaste_id, membernative, height, weight, religion_id, lifestyles, known_languages, education, job, city_id, state_id, income, zodiac_sign, hobbies, expectations from memberdetails as md join member as m on md.member_id=m.member_id  where md.member_id= :id", nativeQuery = true)
//	UpdateMember getMemberDetailsByID(int id);

	@Query(value="SELECT * FROM memberdetails as md join member as m on md.member_id=m.member_id where md.member_id= :id",nativeQuery=true)
	UpdateMember getMemberDetailsByID(int id);

	@Query(value="SELECT * FROM memberdetails as md join member as m on md.member_id=m.member_id where m.member_number= :member_number",nativeQuery=true)
	UpdateMember getDetailsByMemberID(String member_number);
}
