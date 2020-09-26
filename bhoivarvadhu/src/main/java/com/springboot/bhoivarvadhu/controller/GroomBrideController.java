package com.springboot.bhoivarvadhu.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import org.apache.commons.net.ntp.TimeStamp;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.bhoivarvadhu.dao.NewMemberDAO;
import com.springboot.bhoivarvadhu.dto.Info;
import com.springboot.bhoivarvadhu.dto.User;
import com.springboot.bhoivarvadhu.dto.UserDetail;

@RestController
public class GroomBrideController {

	@Autowired
	private NewMemberDAO newMemberDAO;
	private TimeInfo timeInfo;
	private Long offset;

	@RequestMapping(value = "/bride/info/{start}")
	public Stack<List> getBridesInfo(@PathVariable int start) {
		List<User> planinfo = newMemberDAO.getAllBrides(start);
		long planinfo1 = newMemberDAO.getBrideCount();

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

	@RequestMapping(value = "/groom/info/{start}")
	public Stack<List> getGroomInfo(@PathVariable int start) {
		List<User> planinfo = newMemberDAO.getAllGrooms(start);
		long planinfo1 = newMemberDAO.getGroomCount();

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

	@RequestMapping(value = "/allMember/{start}")
	public Stack<List> getAllMemberInfo(@PathVariable int start) throws IOException, ParseException {
		List<User> AllMember = newMemberDAO.getAllMember(start);
		List<User> AllMemberCount = newMemberDAO.getAllMemberCount(start);

		int listCount = AllMemberCount.size();
		System.out.println("listCount : " + listCount);

		System.out.println("this is" + AllMember);

		System.out.println("this is" + AllMemberCount);

		Stack<List> STACK = new Stack<List>();
		final List<Integer> longArray = Arrays.asList(listCount);

		STACK.push(AllMember);
		STACK.push(longArray);

		/// Here we check today date from NTPUDPClient server And not from system time
		final String SERVER_NAME = "pool.ntp.org";

		NTPUDPClient client = new NTPUDPClient();
		// We want to timeout if a response takes longer than 10 seconds
		client.setDefaultTimeout(10_000);

		InetAddress inetAddress = InetAddress.getByName(SERVER_NAME);
		TimeInfo timeInfo = client.getTime(inetAddress);
		timeInfo.computeDetails();
		if (timeInfo.getOffset() != null) {
			this.timeInfo = timeInfo;
			this.offset = timeInfo.getOffset();
		}

		// This system NTP time
		TimeStamp systemNtpTime = TimeStamp.getCurrentTime();
		System.out.println("System time:\t" + systemNtpTime + "  " + systemNtpTime.toDateString());

		// Calculate the remote server NTP time
		long currentTime = System.currentTimeMillis();
		TimeStamp atomicNtpTime = TimeStamp.getNtpTime(currentTime + offset);

		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date(atomicNtpTime.getTime());
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String d = f.format(date);
		System.out.println(d);

		LocalDate TodayDate = LocalDate.parse(d);

	 		System.out.println("Atomic time:\t" + atomicNtpTime + "  " + atomicNtpTime.toDateString());

		/** On what day of each month should the count be reset? 1..28 */
		final int DAY_OF_MONTH_TO_RESET_COUNT = 26;
		/** In what time zone should above day-of-month be interpreted? */
		final ZoneId timeZone = ZoneId.of("Asia/Pontianak");

		// substitute reset_date from DB here
		LocalDate lastResetDate = LocalDate.of(2020, Month.SEPTEMBER, 24);
		
		System.out.println("TodayDate time:\t" + TodayDate);
		System.out.println("lastResetDate time:\t" + lastResetDate);

		LocalDate nextResetDate = lastResetDate.plusDays(1).withDayOfMonth(DAY_OF_MONTH_TO_RESET_COUNT);
		 
		System.out.println("nextResetDate time:\t" + nextResetDate);

		// "not after today" means today or before today

		if (!nextResetDate.isAfter(TodayDate)) {
			System.out.println("Reset the count and update the reset_date in the database");

			int planinfo2 = newMemberDAO.updateClickCounts();

		}

		return STACK;
	}

	@RequestMapping(value = "/Search")
	Stack<List> showSingleProduct(String data) throws JsonParseException, JsonMappingException, IOException {

		System.out.println("this is data" + data);
		Map<String, Object> response = new ObjectMapper().readValue(data, HashMap.class);

		Collection<Object> values = response.values();

		String[] targetArray = values.toArray(new String[0]);

		System.out.println("this is targetArray" + targetArray[1]);

		System.out.println("this is response" + response.get("education"));
		String education1 = (String) targetArray[1];
		String education = (String) response.get("education");

		for (String key : response.keySet()) {
			System.out.println("key : " + key);
			System.out.println("value : " + response.get(key));
//		    String value = (String) response.get(key);
		}

		List<User> planinfo = newMemberDAO.getsearchresults(targetArray);
		List<User> count = newMemberDAO.getsearchresultsCount(targetArray);

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
