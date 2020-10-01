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
	public List<User> getGroomByCity(String logincity, String loginGroom_Bride) {
		String query = "FROM User WHERE (city = :logincity) AND (groom_Bride = :loginGroom_Bride) ";
		return em.createQuery(query, User.class)
				.setParameter("logincity", logincity)
				.setParameter("loginGroom_Bride", loginGroom_Bride)
				.getResultList();
	}

	@Override
	public List<User> getRecentlyaddedMember(String loginGroom_Bride) {
		String query = "FROM User WHERE groom_Bride = :loginGroom_Bride ORDER BY dateTime DESC";
		return em.createQuery(query, User.class)
				.setParameter("loginGroom_Bride", loginGroom_Bride)
				.getResultList();
	}

}
