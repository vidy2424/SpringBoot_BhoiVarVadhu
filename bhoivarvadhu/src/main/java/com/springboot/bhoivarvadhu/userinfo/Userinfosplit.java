package com.springboot.bhoivarvadhu.userinfo;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.springboot.bhoivarvadhu.dao.UserDAO;
import com.springboot.bhoivarvadhu.dto.User;
import com.springboot.bhoivarvadhu.dto.Userinfo;

@Component
public class Userinfosplit {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

//	public User userdetails(Userinfo userinfo) {
//		
//		User user = new User();
//		user.setFirstName(userinfo.getFirstName());
//		user.setLastName(userinfo.getLastName());
//		user.setRole(userinfo.getRole());
//		user.setEmail(userinfo.getEmail());
//		user.setContactNumber(userinfo.getContactNumber());
//		user.setPassword(userinfo.getPassword());
//		user.setConfirmPassword(userinfo.getPassword());
//		return user;
//	}
	
//	public Address addressdetails(Userinfo userinfo) {
		
//		Address address = new Address();
//		address.setAddressLineOne(userinfo.getAddressLineOne());
//		address.setAddressLineTwo(userinfo.getAddressLineTwo());
//		address.setCity(userinfo.getCity());
//		address.setState(userinfo.getState());
//		address.setCountry(userinfo.getCountry());
//		address.setPostalCode(userinfo.getPostalCode());
		
//		return address;
//	}
	
	public String saveuserAll(User user) {
		
		String transitionValue = "success";
		System.out.println("userdetail saved... " + user);
		//System.out.println("Address saved... " + billing);
 		
		User userinfo = user;
// 		if(userinfo.getRole().equals("USER")) { 
//			Cart cart = new Cart();
//			cart.setUser(user);
//			userinfo.setCart(cart);
// 	 	} 
		
		//encode the password
 		userinfo.setPassword(passwordEncoder.encode(user.getPassword()));
 		
		//save the user
		userDAO.add(userinfo);
   		
		//Address billing = model.getBilling();
//		billing.setUserId(user.getId());
//		billing.setBilling(true);
 		
		// save the address
		//userDAO.addAddress(billing);
  		
		return transitionValue;
		}
}
