package com.sathidar.EntityMangerFactory;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sathidar.model.User;

@Service
public class UserEntityManagerFactory {

	@PersistenceContext
	private EntityManager em;

	public int getRoleID(String roleName) {
		int ans = 0;
		try {
			Query q = em.createNativeQuery("select role_id from roles where name=:RoleName and role_status='active'");
			q.setParameter("RoleName", roleName);
			ans = Integer.parseInt(q.getSingleResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}

	@Transactional
	public boolean saveRoleToMember(int getRoleID, int userID) {
		boolean status = false;
		try {
			Query q = em.createNativeQuery("insert into users_roles(user_id,role_id) values(:userID, :roleID)");
			q.setParameter("userID", userID);
			q.setParameter("roleID", getRoleID);
			q.executeUpdate();
//			em.getTransaction().commit();
			em.close();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int getLastInsertedID() {
		int ans = 0;
		try {
			Query q = em.createNativeQuery("SELECT id FROM users order by id DESC LIMIT 1");
			ans = Integer.parseInt(q.getSingleResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}

	@Transactional
	public int insertRecordToMemberTable(User user, int getRoleID, int getLastInsertedID) {
		int memberStatus=0,statsCount=0;
		try {
			
			String queryInsertMember="insert into member(first_name,last_name,gender,contact_number,email_id,profilecreatedby,user_id,role_id) values(:first_name,:last_name,:gender,:contact_number,:email_id,:profilecreatedby,:user_id,:role_id)";
			Query q = em.createNativeQuery(queryInsertMember);
			q.setParameter("first_name", user.getFirstName());
			q.setParameter("last_name", user.getLastName());
			q.setParameter("gender", user.getGender());
			q.setParameter("contact_number", user.getPhone());
			q.setParameter("email_id", user.getEmail());
			q.setParameter("profilecreatedby", user.getProfilecreatedby());
			q.setParameter("user_id", getLastInsertedID);
			q.setParameter("role_id", getRoleID);
			statsCount= q.executeUpdate();
			// em.getTransaction().commit();
			em.close();
			
			Query queryGetLastInsertedValue = em.createNativeQuery("SELECT LAST_INSERT_ID()");
			BigInteger biid = (BigInteger) queryGetLastInsertedValue.getSingleResult();
			int id = biid.intValue();
			
			String number="";
			int lengthOfID = String.valueOf(id).length(); 
			if(lengthOfID==1)
				number="00"+id;
			if(lengthOfID==2)
				number="0"+id;
			
			String memberNumber="";
			String mGender="";
			if(user.getGender().trim()!="" && user.getGender().trim()!=null)
			{
				mGender=user.getGender().trim();
				char ch= mGender.charAt(0);
				if(ch=='f' || ch=='F') {
					memberNumber="FSD"+number;
				}else if(ch=='m' || ch=='M') {
					memberNumber="MSD"+number;}
			}
			
			Query queryMemberNumber = em.createNativeQuery(
					"update member set member_number= :MemberNumber where member_id= :MemberID");
			queryMemberNumber.setParameter("MemberNumber",memberNumber);
			queryMemberNumber.setParameter("MemberID",id);
			statsCount= queryMemberNumber.executeUpdate();
			
			Query queryMemberDetails = em.createNativeQuery(
					"insert into memberdetails(member_id) values(:MemberID)");
			queryMemberDetails.setParameter("MemberID",id);
			statsCount= queryMemberDetails.executeUpdate();
			// em.getTransaction().commit();
			em.close();
			memberStatus=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberStatus;
	}

	@Transactional
	public boolean saveTempOTP(String contactNumber, String otp) {
		boolean status=false;
		try {
			Query queryMemberDetails = em.createNativeQuery(
					"insert into tempsendotp(conactno,otp) values(:ContactNo,:OTP)");
			queryMemberDetails.setParameter("ContactNo",contactNumber);
			queryMemberDetails.setParameter("OTP",otp);
		    queryMemberDetails.executeUpdate();
		    
	
			// em.getTransaction().commit();
			em.close();
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	
	public boolean verifyMemberOtp(String mOtp, String contactNo) {
		boolean status=false;
		try {
			Query q = em.createNativeQuery("SELECT otp FROM tempsendotp where conactno= :ContactNo  order by id DESC LIMIT 1");
			q.setParameter("ContactNo", contactNo);
			int ans = Integer.parseInt(q.getSingleResult().toString());
			if(ans==Integer.parseInt(mOtp))
				status= true;
			else
				status= false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
