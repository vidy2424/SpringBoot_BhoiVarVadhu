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

import com.springboot.bhoivarvadhu.dao.NewMemberDAO;
import com.springboot.bhoivarvadhu.dao.UserDAO;
import com.springboot.bhoivarvadhu.dto.RegisterForm;
import com.springboot.bhoivarvadhu.dto.TeamMembers;
import com.springboot.bhoivarvadhu.dto.User;
  
@Repository("NewMemberDAO")
@Transactional
public class NewMemberDAOImpl implements NewMemberDAO {

	@Autowired
	private UserDAO userDAO;
	
	@PersistenceContext
	@Autowired
	private EntityManager em;

	@Override
	public boolean addNewMember(User User) {
		try {
			em.persist(User);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/*
	 * @Override public boolean updateUser(User User) { try
	 * { em.merge(User); return true; } catch (Exception ex) {
	 * //ex.printStackTrace(); return false; } }
	 */

	@Override
	public boolean update(User User) {
		try {
			em.merge(User);
			return true;
		} catch (Exception ex) {
			// ex.printStackTrace();
			return false;
		}
	}

//	@Override
//	public boolean deleteUser1(int id) {
//		try {
//			em.merge(User);
//			return true;
//		} catch (Exception ex) {
//			// ex.printStackTrace();
//			return false;
//		}
//	}

	@Override
	public boolean deleteMember(int id) {
		try {

			em.createQuery("delete from User where id = :id").setParameter("id", id).executeUpdate();
		} catch (Exception ex) {
			// ex.printStackTrace();
		}
		return false;
	}

//	@Override
//	public List<User> getNewMemberbyID(int id) {
//		String query = "FROM User WHERE id = :id";
//		System.out.println("hiiiii" + query);
//		return em.createQuery(query, User.class).setParameter("id", id).getResultList();
//	}

 
//	@Override
//	public List<User> getAllUser1() {
//		String query = "SELECT Count(*) FROM User ";
//		  return em.createQuery(query, User.class).getResultList();
// 
//	}

	@Override
	public long getGroomCount() {
		Query queryTotal = em.createQuery("Select count(f.id) from User f WHERE Groom_Bride = 'groom'");
		long countResult = (long) queryTotal.getSingleResult();
		// System.out.println("Total Count :" +countResult);
		return countResult;
	}

	@Override 
	public long getBrideCount() {
		Query queryTotal = em.createQuery("Select count(f.id) from User f WHERE Groom_Bride = 'bride'");
		long countResult = (long) queryTotal.getSingleResult();
		// System.out.println("Total Count :" +countResult);
		return countResult;
	}
	
	
	
 	
	@Override
	public List<User> getAllBrides(int start) {
		
		
		String query = "FROM User WHERE Groom_Bride = 'bride'";
 
 
 		return em.createQuery(query, User.class)
				.setFirstResult((start - 1) * 5)
 				.setMaxResults(5)
				.getResultList(); 
	}
	
 	@Override
	public List<User> getAllGrooms(int start) {
		
		String query = "FROM User WHERE Groom_Bride = 'groom'";

 
 		return em.createQuery(query, User.class)
				.setFirstResult((start - 1) * 5)
 				.setMaxResults(5)
				.getResultList(); 
	}
	
	@Override
	public List<User> getAllMember(int start) {
		
		
		String query = "FROM User ORDER BY dateTime DESC";
 
 
 		return em.createQuery(query, User.class)
				.setFirstResult((start - 1) * 20)
 				.setMaxResults(20)
				.getResultList(); 
	}

	@Override
	public List<User> getAllMemberCount(int start) {
		String query = "FROM User ORDER BY dateTime DESC";
 		return em.createQuery(query, User.class)
			 	.getResultList();
	}
 	
 	
	@Override
	public List<User> getsearchresults(String[] targetArray) {
	    System.out.println("targetArrayImpl : " + targetArray);
		String education = (String) targetArray[0];
		String city = (String) targetArray[1];
		String age_from = (String) targetArray[2];
	    System.out.println("targetArrayImpl : " + age_from);

		String page = (String) targetArray[3];
//	    System.out.println("targetArrayImpl : " + page);

		String age_to = (String) targetArray[5];
		int ageFrom=Integer.parseInt(age_from);  
		int ageTo=Integer.parseInt(age_to);  
		int start=Integer.parseInt(page);  

		
		String groom_bride = (String) targetArray[4];
 
	 	String query = "FROM User WHERE (education = :education) OR (city = :city) OR (groom_Bride = :groom_bride) OR (age BETWEEN :ageFrom AND :ageTo)";
//	 	String query = "FROM User WHERE age BETWEEN :ageFrom AND :ageTo";

	 	return em
					.createQuery(query,User.class)
					.setParameter("education",education)
					.setParameter("city",city)
					.setParameter("ageFrom",ageFrom)
					.setParameter("ageTo",ageTo)
					.setParameter("groom_bride", groom_bride)
					.setFirstResult((start - 1) * 5)
	 				.setMaxResults(5)
					.getResultList();
	 }	

	@Override
	public List<User> getsearchresultsCount(String[] targetArray) {
	    System.out.println("targetArrayImpl : " + targetArray);
		String education = (String) targetArray[0];
		String city = (String) targetArray[1];
		String age_from = (String) targetArray[2];
	    System.out.println("targetArrayImpl : " + age_from);

		String page = (String) targetArray[3];
//	    System.out.println("targetArrayImpl : " + page);

		String age_to = (String) targetArray[5];
		int ageFrom=Integer.parseInt(age_from);  
		int ageTo=Integer.parseInt(age_to);  
		int start=Integer.parseInt(page);  

		
		String groom_bride = (String) targetArray[4];
 
	 	String query = "FROM User WHERE (education = :education) OR (city = :city) OR (groom_Bride = :groom_bride) OR (age BETWEEN :ageFrom AND :ageTo)";
//	 	String query = "FROM User WHERE age BETWEEN :ageFrom AND :ageTo";

	 	return em
					.createQuery(query,User.class)
					.setParameter("education",education)
					.setParameter("city",city)
					.setParameter("ageFrom",ageFrom)
					.setParameter("ageTo",ageTo)
					.setParameter("groom_bride", groom_bride)
//					.setFirstResult((start - 1) * 5)
//	 				.setMaxResults(5)
					.getResultList();
	 }	
	

//	@Override
//	public List<User> getGroomByID2(int id) { 
//		String query = "FROM User  ORDER BY id DESC ";
//
//		return em.createQuery(query, User.class).getResultList();
//	}

	@Override 
	public List<User> getDetailByID(int id) {
	 	String query = "FROM User WHERE id = :id";
	 	return em
					.createQuery(query,User.class)
					.setParameter("id",id)	
					.getResultList();
	 }

	
	public int updateClickCounts() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userDAO.getByEmail(authentication.getName());
		
		int logingID = user.getId();
		System.out.println("logingcity" + logingID);
		
	 	int clickCount = 0;
 
		System.out.println("clicksImpl : " + clickCount);
 	
		User userInfo= (User)em.find(User.class ,logingID);
		userInfo.setClickCount(clickCount);
		return clickCount;
		
	}
	
	
	@Override
	public RegisterForm getid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllNewMember(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getsearchresults(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNewMemberCount() {
		// TODO Auto-generated method stub
		return 0;
	}	
 	
}
