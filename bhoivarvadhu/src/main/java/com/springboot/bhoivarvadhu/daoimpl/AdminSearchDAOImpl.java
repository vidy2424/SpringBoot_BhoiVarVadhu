package com.springboot.bhoivarvadhu.daoimpl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bhoivarvadhu.dao.AdminSearchDAO;
import com.springboot.bhoivarvadhu.dao.NewMemberDAO;
import com.springboot.bhoivarvadhu.dao.UserDAO;
import com.springboot.bhoivarvadhu.dto.RegisterForm;
import com.springboot.bhoivarvadhu.dto.User;

@Repository("AdminSearchDAO")
@Transactional
public class AdminSearchDAOImpl implements AdminSearchDAO {

	@Autowired
	private UserDAO userDAO;

	@PersistenceContext
	@Autowired
	private EntityManager em;

	@Override
	public List<User> getSearchByCity(String[] targetArray) {
		System.out.println("targetArrayImpl : " + targetArray);
		String city = (String) targetArray[0];
		System.out.println("targetArrayImpl : " + city);
		String contact = (String) targetArray[1];
		String name = (String) targetArray[2];
		String page = (String) targetArray[3];
		
		 String user_ID = (String) targetArray[4];
		 String email = (String) targetArray[5];

//		long contactNo = Long.parseLong(contact);
		 int userID = Integer.parseInt(user_ID);
		 
		int start = Integer.parseInt(page);

		String query = "FROM User WHERE(city = :city)OR (contact_No_1 = :contact)OR (fullName = :name)OR (email = :email)OR (id = :userID)";
		return em.createQuery(query, User.class)
				.setParameter("city", city)
				.setParameter("contact", contact)
				.setParameter("name", name)
				.setParameter("email", email)
				.setParameter("userID", userID)
				.setFirstResult((start - 1) * 10)
				.setMaxResults(10).getResultList();
	}

	@Override
	public List<User> getSearchByCityCount(String[] targetArray) {
		System.out.println("targetArrayImpl : " + targetArray);
		String city = (String) targetArray[0];
		System.out.println("targetArrayImpl : " + city);
		String contact = (String) targetArray[1];
		String name = (String) targetArray[2];
		String page = (String) targetArray[3];
		String user_ID = (String) targetArray[4];
		String email = (String) targetArray[5];

//		long contactNo = Long.parseLong(contact);
		int userID = Integer.parseInt(user_ID);

		int start = Integer.parseInt(page);

		String query = "FROM User WHERE(city = :city)OR (contact_No_1 = :contact)OR (fullName = :name)OR (email = :email)OR (id = :userID)";
		return em.createQuery(query, User.class).setParameter("city", city).setParameter("contact", contact)
				.setParameter("name", name).setParameter("email", email).setParameter("userID", userID).getResultList();

	}

	@Override
	public int updateClickCounts(String[] targetArray) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userDAO.getByEmail(authentication.getName());

		int logingID = user.getId();
		System.out.println("logingcity" + logingID);

		String click = (String) targetArray[0];
		int clickCount = Integer.parseInt(click);

		System.out.println("clicksImpl : " + clickCount);
//		String city = (String) targetArray[0];

//		long contactNo = Long.parseLong(contact);

//		String query = "update User set clickCount = :clickCount where id =:logingID";
//		return em.createQuery(query, User.class)
//				 .executeUpdate();
//

		User userInfo = (User) em.find(User.class, logingID);
		userInfo.setClickCount(clickCount);
		return clickCount;

	}

}
