package com.springboot.bhoivarvadhu.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.bhoivarvadhu.dao.AdminSearchDAO;
import com.springboot.bhoivarvadhu.dao.NewMemberDAO;
import com.springboot.bhoivarvadhu.dto.Info;
import com.springboot.bhoivarvadhu.dto.User;
import com.springboot.bhoivarvadhu.dto.UserDetail;

@RestController
public class AdminSearchController {

	@Autowired
	private AdminSearchDAO adminSearchDAO;

//	@RequestMapping(value = "/bride/info/{start}")
//	public Stack<List> getBridesInfo(@PathVariable int start) {
//		List<User> planinfo = newMemberDAO.getAllBrides(start);
//		long planinfo1 = newMemberDAO.getBrideCount();
//
//		System.out.println("this is" + planinfo);
//
//		System.out.println("this is" + planinfo1);
//		List<List<User>> strings = Arrays.asList(planinfo);
//		String str = String.valueOf(planinfo1);
//		Stack<List> STACK = new Stack<List>();
//		final List<Long> longArray = Arrays.asList(planinfo1);
//		STACK.push(planinfo);
//		STACK.push(longArray);
//
//		return STACK;
//
//	}
 
	@RequestMapping(value = "/SearchDataByCity")
	Stack<List> showSingleProduct( String data)
			throws JsonParseException, JsonMappingException, IOException {

		System.out.println("this is data" + data);
		Map<String, Object> response = new ObjectMapper().readValue(data, HashMap.class);

		Collection<Object> values = response.values();

		String[] targetArray = values.toArray(new String[0]);

		System.out.println("this is targetArray" + targetArray[0]);

		System.out.println("this is response" + response.get("city"));
		String city = (String) targetArray[0];
		 
		for (String key : response.keySet()) {
			System.out.println("key : " + key);
			System.out.println("value : " + response.get(key));
//		    String value = (String) response.get(key);
		}

		List<User> planinfo = adminSearchDAO.getSearchByCity(targetArray);
		List<User> count = adminSearchDAO.getSearchByCityCount(targetArray);
 
		int listCount = count.size();
		System.out.println("listCount : " + listCount);

		System.out.println("this is education" + planinfo);

		List<List<User>> strings = Arrays.asList(planinfo);
		String str = String.valueOf(count);
		Stack<List> STACK = new Stack<List>();
		final List<Integer> longArray = Arrays.asList(listCount);
		STACK.push(planinfo);
		STACK.push(longArray);
		return STACK;
 
	}

 
}
