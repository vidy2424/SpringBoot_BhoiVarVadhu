package com.springboot.bhoivarvadhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bhoivarvadhu.dao.RelatedCardsDAO;
import com.springboot.bhoivarvadhu.dao.UserDAO;
import com.springboot.bhoivarvadhu.dto.User;

@RestController
public class RelatedCardsController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RelatedCardsDAO relatedCardsDAO;

	@RequestMapping(value = "/groom/city")
	public List<User> getGroomByCity() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userDAO.getByEmail(authentication.getName());
		
		String logingcity = user.getCity();
		System.out.println("logingcity" + logingcity);

		List<User> GroomByCity = relatedCardsDAO.getGroomByCity(logingcity);
		 
		
		int logingid = user.getId();
		System.out.println("logingid" + logingid);
		          
		
		// List<SignUpUser> sign15 = signupDAO.loginbyName(signUpUser.getName());

		// List<User> sign1 = new ArrayList<>();

		System.out.println("GroomByCity" + GroomByCity);
		return GroomByCity;
	}
	
	@RequestMapping(value = "/Recentlyadded")
	public List<User> getRecentlyadded() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userDAO.getByEmail(authentication.getName());
		
		String logincity = user.getCity();
		System.out.println("logincity" + logincity);
 		List<User> RecentlyaddedMember = relatedCardsDAO.getRecentlyaddedMember();
  
		// List<SignUpUser> sign15 = signupDAO.loginbyName(signUpUser.getName());

		// List<User> sign1 = new ArrayList<>();

		System.out.println("RecentlyaddedMember" + RecentlyaddedMember);
		return RecentlyaddedMember;
	}
	
	
}
