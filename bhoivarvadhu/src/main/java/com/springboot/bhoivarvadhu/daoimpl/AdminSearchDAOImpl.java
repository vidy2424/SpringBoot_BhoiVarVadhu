package com.springboot.bhoivarvadhu.daoimpl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bhoivarvadhu.dao.AdminSearchDAO;
import com.springboot.bhoivarvadhu.dao.NewMemberDAO;
import com.springboot.bhoivarvadhu.dto.RegisterForm;
import com.springboot.bhoivarvadhu.dto.User;
  
@Repository("AdminSearchDAO")
@Transactional
public class AdminSearchDAOImpl implements AdminSearchDAO {

	@PersistenceContext
	@Autowired
	private EntityManager em;
 
	@Override
	public List<User> getAllNewMember(int start) {
		String query = "FROM User  ORDER BY id DESC ";

		return em.createQuery(query, User.class).getResultList();
	}
 
	@Override
	public long getNewMemberCount() {
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
	public List<User> getSearchByCity(String[] targetArray) {
	    System.out.println("targetArrayImpl : " + targetArray);
		 String city = (String) targetArray[0];
  	    System.out.println("targetArrayImpl : " + city);

		String page = (String) targetArray[1];
 		int start=Integer.parseInt(page);  

 	 	String query = "FROM User WHERE(city = :city)";
 	 	return em
					.createQuery(query,User.class)
					.setParameter("city",city)
					 .setFirstResult((start - 1) * 10)
	 				.setMaxResults(10)
					.getResultList();
	 }	

	@Override
	public List<User> getSearchByCityCount(String[] targetArray) {
	    System.out.println("targetArrayImpl : " + targetArray);
	 	String city = (String) targetArray[0];
	 
		String page = (String) targetArray[1];
  		int start=Integer.parseInt(page);  
 	 	String query = "FROM User WHERE(city = :city)";
 
	 	return em
					.createQuery(query,User.class)
					.setParameter("city",city)
//					 .setFirstResult((start - 1) * 5)
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
	
	@Override
	public RegisterForm getid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getsearchresults(int start) {
		// TODO Auto-generated method stub
		return null;
	}
 	
}
