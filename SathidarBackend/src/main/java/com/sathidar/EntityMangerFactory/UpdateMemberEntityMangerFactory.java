package com.sathidar.EntityMangerFactory;
import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class UpdateMemberEntityMangerFactory {

	@PersistenceContext
	private EntityManager em;
	
}
