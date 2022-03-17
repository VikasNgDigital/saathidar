package com.sathidar.EntityMangerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class UserEntityManagerFactory {

	@PersistenceContext
	private EntityManager em;

	public int getRoleID(String roleName) {
		int ans=0;
		try {
			Query q = em.createNativeQuery("select role_id from roles where name=:RoleName and role_status='active'");
			q.setParameter("RoleName",  roleName);
			ans=Integer.parseInt(q.getSingleResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}

	@Transactional
	public boolean saveRoleToMember(int getRoleID, int userID) {
		boolean status = false;
		try {
					Query q = em.createNativeQuery(
							"insert into users_roles(user_id,role_id) values(:userID, :roleID)");
					q.setParameter("userID", userID);
					q.setParameter("roleID", getRoleID);
					q.executeUpdate();
//			em.getTransaction().commit();
			em.close();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getLastInsertedID() {
		int ans=0;
		try {
			Query q = em.createNativeQuery("SELECT id FROM users order by id DESC LIMIT 1");
			 ans=Integer.parseInt(q.getSingleResult().toString());		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
}
