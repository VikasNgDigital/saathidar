package com.sathidar.service;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathidar.model.UpdateMember;
import com.sathidar.repository.UpdateMemberRepository;

@Service
public class UpdateMemberServiceImpl implements UpdateMemberService {

	
	@Autowired
	UpdateMemberRepository updateMemberRepository;
	
	@Override
	public Object UpdateMemberDetails(UpdateMember updateMember, int id) {
		
		updateMember.setId(id);
		String mNative=updateMember.getMembernative().trim();
		
		double dHeight =updateMember.getHeight();
        DecimalFormat dfHeight = new DecimalFormat("#.##");
		double mHeight=Double.parseDouble(dfHeight.format(dHeight));
		
		double dWeight =updateMember.getWeight();
        DecimalFormat dfWeight = new DecimalFormat("#.##");
		double mWeight=Double.parseDouble(dfWeight.format(dWeight));
		
		String mLifeStyles=updateMember.getLifestyles().trim();
		String mKnown_Languages=updateMember.getKnown_languages().trim();
		String mEducation=updateMember.getEducation().trim();
		String mJob=updateMember.getJob().trim();
		String mIncome=updateMember.getIncome().trim();
		String mHobbies=updateMember.getHobbies().trim();
		String mExpectation=updateMember.getExpectations().trim();
		
		
		return updateMemberRepository.UpdateMemberDetails(mNative,mHeight,mWeight,mLifeStyles,mKnown_Languages,mEducation,mJob,mIncome,mHobbies,mExpectation, id);
	}

	@Override
	public UpdateMember getMemberDetails(int id) {		
		return updateMemberRepository.getMemberDetailsByID(id);
	}

	@Override
	public UpdateMember getDetailsByMemberID(String member_number) {
		return updateMemberRepository.getDetailsByMemberID(member_number);
	}
}
