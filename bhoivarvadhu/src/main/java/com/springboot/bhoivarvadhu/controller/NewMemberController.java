package com.springboot.bhoivarvadhu.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.bhoivarvadhu.dao.NewMemberDAO;
import com.springboot.bhoivarvadhu.dto.User;
import com.springboot.bhoivarvadhu.util.FileUploadUtility;
import com.springboot.bhoivarvadhu.validator.AddMemberDetails;
import com.springboot.bhoivarvadhu.validator.ProductValidator;

@RestController
public class NewMemberController {

	@Autowired
	private NewMemberDAO newMemberDAO;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// add and edit product
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String managePostProduct(@RequestParam(name = "data", required = false) String add,
			@RequestParam(name = "file") MultipartFile file, HttpServletRequest request) throws ParseException {
		Map<String, String> map2 = new HashMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			// convert JSON string to Map
			map2 = mapper.readValue(add, new TypeReference<HashMap<String, String>>() {
			});
			System.out.println(map2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		AddMemberDetails detail = new AddMemberDetails();
		User mProduct = detail.addmember(map2, file);

		// mandatory file upload check
		if (mProduct.getId() == 0) {
			new ProductValidator().validateMember(mProduct);
		} else {
			// edit check only when the file has been selected
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validateMember(mProduct);
			}
		}

		if (mProduct.getId() == 0) {

			// set password
			mProduct.setPassword(passwordEncoder.encode(mProduct.getPassword()));

	        Calendar cal = Calendar.getInstance();

	        mProduct.setDateTime(new Timestamp(cal.getTimeInMillis()));
			
			// calculate age froem dob
			String dateofBirth = mProduct.getdOB();

			dateofBirth = dateofBirth.split("T")[0];

 			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = (Date) formatter.parse(dateofBirth);

			Instant instant = date.toInstant();
			ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
			LocalDate givenDate = zone.toLocalDate();
			Period period = Period.between(givenDate, LocalDate.now());

			int newage = period.getYears();

			System.out.print(period.getYears() + " years " + period.getMonths() + " and " + period.getDays() + " days");

			mProduct.setPassword(passwordEncoder.encode(mProduct.getPassword()));

			// set age
			mProduct.setAge(newage);
			;

			String LookingGroomOrBride = mProduct.getGroom_Bride();
 			
			String groom = "groom";
			
			if(LookingGroomOrBride.equals(groom)) {
				String female = "female";
				mProduct.setGender(female);
				System.out.print(female);
			}else {
				String male = "male";
				mProduct.setGender(male);
				System.out.print(male);
			}
			 
			newMemberDAO.addNewMember(mProduct);

		} else {
			// Update age
			String dateofBirth = mProduct.getdOB();
			dateofBirth = dateofBirth.split("T")[0];

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = (Date) formatter.parse(dateofBirth);

			Instant instant = date.toInstant();
			ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
			LocalDate givenDate = zone.toLocalDate();
			Period period = Period.between(givenDate, LocalDate.now());

			int newage = period.getYears();

			System.out.print(period.getYears() + " years " + period.getMonths() + " and " + period.getDays() + " days");
			mProduct.setAge(newage);

			// Update gender
			String LookingGroomOrBride = mProduct.getGroom_Bride();
 			
			String groom = "groom";
			
			if(LookingGroomOrBride.equals(groom)) {
				String female = "female";
				mProduct.setGender(female);
				System.out.print(female);
			}else {
				String male = "male";
				mProduct.setGender(male);
				System.out.print(male);
			}
 
			newMemberDAO.update(mProduct);
		}

		// upload the file
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/product?success=product";
	}

	@RequestMapping(value = "/member/info/{start}")
	public Stack<List> getAllOurproduct(@PathVariable int start) {
		List<User> planinfo = newMemberDAO.getAllNewMember(start);
		long planinfo1 = newMemberDAO.getNewMemberCount();

		System.out.println("this is" + planinfo);

		System.out.println("this is" + planinfo1);
		List<List<User>> strings = Arrays.asList(planinfo);
		String str = String.valueOf(planinfo1);
		Stack<List> STACK = new Stack<List>();
		final List<Long> longArray = Arrays.asList(planinfo1);
		STACK.push(planinfo);
		STACK.push(longArray);
		return STACK;
	}

	@DeleteMapping("/memberDelete/{id}")
	public void deleteOurproduct(@PathVariable int id) {
		newMemberDAO.deleteMember(id);
		System.out.println("this is delete");
	}

	@RequestMapping("/getDetailbyID/{id}")
	public List<User> groomDetail(@PathVariable int id) {
		List<User> memberbyID = newMemberDAO.getDetailByID(id);

		newMemberDAO.getDetailByID(id);
		System.out.println("this is groom" + memberbyID);

		System.out.println("this is groom id" + id);
		return memberbyID;
	}

}
