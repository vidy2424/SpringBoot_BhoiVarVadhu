package com.springboot.bhoivarvadhu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springboot.bhoivarvadhu.dao.UserDAO;
import com.springboot.bhoivarvadhu.dto.User;
import com.springboot.bhoivarvadhu.model.UserModel;


@ControllerAdvice
public class GlobalController {
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private HttpSession session;
	
	private UserModel userModel = null;
	private User user = null;	
	
	
	@ModelAttribute("userModel")
	public String getUserModel() {		
		if(session.getAttribute("userModel")==null) {
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			System.out.println(authentication);
			
			if(authentication.getPrincipal().equals("anonymousUser")){
				// get the user from the database
				//user = userDAO.getByEmail(authentication.getName());
				
				//if(user ==null) {
					// create a new model
//					userModel = new UserModel();
//					// set the name and the id 
//					userModel.setId(user.getId());
//					userModel.setFullName(user.getFirstName() + " " + user.getLastName());
//					userModel.setRole(user.getRole());
//					System.out.println("user role == " + user.getRole());
//					
//					if(user.getRole().equals("USER")) {
//						userModel.setCart(user.getCart());
//						//System.out.println("cart == " + user.getCart());
//					}				
	
//					session.setAttribute("userModel", userModel);
					return "redirect:/info";
				//}			
			} 
		}
		
		return (String) session.getAttribute("userModel");		
	}
		
}