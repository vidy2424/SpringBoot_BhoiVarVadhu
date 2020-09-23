package com.springboot.bhoivarvadhu.validator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.bhoivarvadhu.dto.User;

public class AddMemberDetails {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	public User addmember(Map<String, String> member , MultipartFile file) {
		
		System.out.println("member "+ member);
		
		User register = new User();
		
 
		System.out.println("product === " +register.getId());
		int id = member.containsKey("id") && !member.get("id").isEmpty() ? Integer.parseInt((String) member.get("id")) : 0;
		register.setId(id);
		register.setFullName(member.get("fullName"));
		register.setdOB(member.get("dOB"));
		register.setMarital_Status(member.get("marital_Status"));
		register.setCaste(member.get("caste"));
		register.setYour_Surname(member.get("your_Surname"));
		register.setMaternal_Uncle_Surname(member.get("maternal_Uncle_Surname"));
		register.setOther_Surname(member.get("other_Surname"));
		register.setMaternal_Uncle_Surname_optional(member.get("maternal_Uncle_Surname_optional"));
		register.setJob_business(member.get("job_business"));
		register.setAnnual_Income(member.get("annual_Income"));
 		register.setEducation(member.get("education"));
		register.setOccupation(member.get("occupation"));
		register.setFather(member.get("father"));
		register.setGroom_Bride(member.get("groom_Bride"));
		register.setMother(member.get("mother"));
		register.setBrother(member.get("brother"));
		register.setSister(member.get("sister"));
		register.setMarried_Brother(member.get("married_Brother"));
		register.setMarried_Sister(member.get("married_Sister"));
		register.setEmail(member.get("email"));
		register.setPassword(member.get("password"));
		 
//		register.setPassword(passwordEncoder.encode(register.getPassword()));

 		register.setPermanent_Address(member.get("permanent_Address"));
		register.setCurrent_Address(member.get("current_Address"));
		register.setCity(member.get("city"));
		register.setContact_No_1(member.get("contact_No_1"));
		register.setContact_No_2(member.get("contact_No_2"));
		register.setLandline_No(member.get("landline_No"));
		register.setZodiac_Sign(member.get("zodiac_Sign"));
		register.setNakshatras(member.get("nakshatras"));
		register.setBirth_Time(member.get("birth_Time")); 
		register.setBirth_Place(member.get("birth_Place"));
		register.setBirth_Time_HrMin(member.get("birth_Time_HrMin"));
		register.setNadi(member.get("nadi"));
		register.setHeight(member.get("height"));
		register.setWeight(member.get("weight"));
		register.setBlood_Group(member.get("blood_Group"));
		register.setComplexion(member.get("complexion"));
		register.setMangal(member.get("mangal"));				
		register.setPhysical_Disability(member.get("physical_Disability"));
		register.setMention_Physical_Disability(member.get("mention_Physical_Disability"));
		register.setEducation_Expectation(member.get("education_Expectation"));
		register.setCity_Priority_Expectation(member.get("city_Priority_Expectation"));
		register.setOther_Expectation(member.get("other_Expectation"));
		register.setRole(member.get("role"));
		register.setFile(file);
 		return register;	
	}
}
