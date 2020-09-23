package com.springboot.bhoivarvadhu.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bhoivarvadhu.dao.RelatedCardsDAO;
import com.springboot.bhoivarvadhu.dto.User;

@Repository("RelatedCardsDAO")
@Transactional
public class RelatedCardsImpl implements RelatedCardsDAO {

	@PersistenceContext
	@Autowired
	private EntityManager em; 
	
	@Override
	public List<User>  getGroomByCity(String logincity) {
		String query = "FROM User WHERE city = :logincity";
		System.out.println("hiiiii" + query);

		return em
				.createQuery(query,User.class)
 				.setParameter("logincity",logincity)
				.getResultList();
	}
	
	@Override
	public List<User>  getRecentlyaddedMember() {
		String query = "FROM User ORDER BY dateTime DESC";
		System.out.println("hiiiii" + query);

		return em
				.createQuery(query,User.class)
 				.getResultList();
	}
	
	
}
