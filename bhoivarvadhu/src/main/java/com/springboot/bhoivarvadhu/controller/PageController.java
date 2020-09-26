package com.springboot.bhoivarvadhu.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bhoivarvadhu.dao.AdminSearchDAO;
import com.springboot.bhoivarvadhu.dao.UserDAO;
import com.springboot.bhoivarvadhu.dto.User;
import com.springboot.bhoivarvadhu.dto.Userinfo;
import com.springboot.bhoivarvadhu.repository.JwtTokenRepository;
import com.springboot.bhoivarvadhu.userinfo.Userinfosplit;

//@RequestMapping("/")
@RestController
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private AdminSearchDAO adminSearchDAO;
	
	@Autowired
	private Userinfosplit split;

	@Autowired
	private JwtTokenRepository jwtTokenRepository;

	TransportClient client;

	public PageController(JwtTokenRepository jwtTokenRepository) {
		this.jwtTokenRepository = jwtTokenRepository;
	}
 	@PostMapping(value = "/membershipdetail")
	public String register(@RequestBody Userinfo userinfo) {
 
//		System.out.println("userdetail " + user);

		logger.info("Page Controller membership called!");
		return "";
	}

	@RequestMapping(value = "/userinfo")
	public Map<String, Object> userinfo(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> userdetailMap = new HashMap<String, Object>();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// System.out.println("authentication ===" + authentication);
 		// Boolean keyBlacklist = jwtTokenRepository.exist(blackListToken);
 		
		// if(request.getHeader("Authorization") != null && !keyBlacklist) {
		// System.out.println(authentication.getName());
		User user = userDAO.getByEmail(authentication.getName());
		userdetailMap.put("id", user.getId());
		userdetailMap.put("fullname", user.getFullName());
		userdetailMap.put("dOB", user.getdOB());
		userdetailMap.put("marital_Status", user.getMarital_Status());
		userdetailMap.put("caste", user.getCaste());
		userdetailMap.put("your_Surname", user.getYour_Surname());
		userdetailMap.put("maternal_Uncle_Surname", user.getMaternal_Uncle_Surname());
		userdetailMap.put("other_Surname", user.getOther_Surname());
		userdetailMap.put("maternal_Uncle_Surname_optional", user.getMaternal_Uncle_Surname_optional());
		userdetailMap.put("job_business", user.getJob_business());
		userdetailMap.put("father", user.getFather());
		userdetailMap.put("education", user.getEducation());
		userdetailMap.put("occupation", user.getOccupation());
		userdetailMap.put("groom_Bride", user.getGroom_Bride());
		userdetailMap.put("mother", user.getMother());
		userdetailMap.put("brother", user.getBrother());
		userdetailMap.put("sister", user.getSister());
		userdetailMap.put("married_Brother", user.getMarried_Brother());
		userdetailMap.put("married_Sister", user.getMarried_Sister());
		userdetailMap.put("email", user.getEmail());
		userdetailMap.put("permanent_Address", user.getPermanent_Address());
		userdetailMap.put("current_Address", user.getCurrent_Address());
		userdetailMap.put("city", user.getCity());
		userdetailMap.put("contact_No_1", user.getContact_No_1());
		userdetailMap.put("contact_No_2", user.getContact_No_2());
		userdetailMap.put("landline_No", user.getLandline_No());
		userdetailMap.put("zodiac_Sign", user.getZodiac_Sign());
		userdetailMap.put("mangal", user.getMangal());
		userdetailMap.put("nakshatras", user.getNakshatras());
		userdetailMap.put("birth_Time", user.getBirth_Time());
		userdetailMap.put("birth_Time_HrMin", user.getBirth_Time_HrMin());
		userdetailMap.put("birth_Place", user.getBirth_Place());
		userdetailMap.put("nadi", user.getNadi());
		userdetailMap.put("height", user.getHeight());
		userdetailMap.put("weight", user.getWeight());
		userdetailMap.put("blood_Group", user.getBlood_Group());
		userdetailMap.put("complexion", user.getComplexion());
		userdetailMap.put("physical_Disability", user.getPhysical_Disability());
		userdetailMap.put("mention_Physical_Disability", user.getMention_Physical_Disability());
		userdetailMap.put("education_Expectation", user.getEducation_Expectation());
		userdetailMap.put("job_Expectation", user.getJob_Expectation());
		userdetailMap.put("annual_Income", user.getAnnual_Income());
		userdetailMap.put("annual_Income_Expectation", user.getAnnual_Income_Expectation());
		userdetailMap.put("age_Difference_Expectation", user.getAge_Difference_Expectation());
		userdetailMap.put("city_Priority_Expectation", user.getCity_Priority_Expectation());
		userdetailMap.put("other_Expectation", user.getOther_Expectation());
		userdetailMap.put("role", user.getRole());
		userdetailMap.put("code", user.getCode());
		userdetailMap.put("clickCount", user.getClickCount());		
		
		
		return userdetailMap;

// 			if(user.getRole().equals("USER")) {
// 				userdetailMap.put("cart", user.getCart());					
// 				System.out.println("cart ===" + user.getCart());
//			}

	}
	// System.out.println("userinfo....");
	// return userdetailMap;

	@RequestMapping(value = "/login")
	public String login(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("login");
		HttpSession session = request.getSession(false);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		System.out.println("auth ===" + auth);
		System.out.println("logout ===" + logout);

		Map<String, Object> mapproducts = new HashMap<String, Object>();
		System.out.println("Login");
		mv.addObject("title", "Login");
		mapproducts.put("title", "Login");
		if (error != null) {
			mv.addObject("message", "Username and Password is invalid!");
			mapproducts.put("message", "Username and Password is invalid!");
		}
		if (logout != null) {
			mv.addObject("logout", "You have logged out successfully!");
			mapproducts.put("logout", "You have logged out successfully!");
		}
		if (request.getHeader("Authorization") != null) {
			System.out.println("request ===" + request.getHeader("Authorization"));
			String blackListToken = request.getHeader("Authorization");
			jwtTokenRepository.save(blackListToken);
			System.out.println("exist ===" + jwtTokenRepository.exist(blackListToken));
		}
		return "mv";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
		// Removes the authentication from securitycontext
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		for (Cookie cookie : request.getCookies()) {
			cookie.setMaxAge(0);
		}
		System.out.println("logout....");
		return "logout";
	}

	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Aha! Caught You.");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		mv.addObject("title", "403 Access Denied");
		return mv;
	}

}
