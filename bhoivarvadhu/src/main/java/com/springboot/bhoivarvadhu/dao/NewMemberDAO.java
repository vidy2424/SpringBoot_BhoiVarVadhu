package com.springboot.bhoivarvadhu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.bhoivarvadhu.dto.RegisterForm;
import com.springboot.bhoivarvadhu.dto.User;


@Service
public interface NewMemberDAO {

	// Our Product 
	
	RegisterForm getid(int id);

	boolean addNewMember(User User);

	boolean update(User User);
	 
	boolean deleteMember(int id);

	List<User> getAllNewMember(int start);

	List<User> getAllBrides(int start);

	List<User> getAllGrooms(int start);
	
//	List<User> getGrooms(String[] targetArray);
	
	List<User> getsearchresults(int start);

	
//	List<OurProducts> getAllOurProducts();
//	List<OurProducts> getAllOurProducts1();
	
	List<User> getAllMember(int start);
	
	
	long getGroomCount();
	
	long getBrideCount();
	long getNewMemberCount();
 
	List<User> getDetailByID(int id);

	List<User> getAccount_Creation_DATEByID(int id);
	
	List<User> getsearchresults(String[] targetArray);
	List<User> getsearchresultsCount(String[] targetArray);

	List<User> getAllMemberCount(int start);

	   int updateClickCounts(); 

  
  }

