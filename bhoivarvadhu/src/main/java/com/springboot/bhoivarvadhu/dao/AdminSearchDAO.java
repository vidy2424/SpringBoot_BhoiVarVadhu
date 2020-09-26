package com.springboot.bhoivarvadhu.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.springboot.bhoivarvadhu.dto.RegisterForm;
import com.springboot.bhoivarvadhu.dto.User;


@Service
public interface AdminSearchDAO {

	List<User> getSearchByCity(String[] targetArray);
	List<User> getSearchByCityCount(String[] targetArray);

	int updateClickCounts(String[] targetArray);

	

	
	
  }

