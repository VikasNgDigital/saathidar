package com.sathidar.service;

import java.util.List;

import com.sathidar.model.UpdateMember;

public interface UpdateMemberService {

	Object UpdateMemberDetails(UpdateMember updateMember, int id);

	UpdateMember getMemberDetails(int id);

	UpdateMember getDetailsByMemberID(String id);


}
