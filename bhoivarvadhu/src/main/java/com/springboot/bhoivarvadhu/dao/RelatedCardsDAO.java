package com.springboot.bhoivarvadhu.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.bhoivarvadhu.dto.User;

@Service
public interface RelatedCardsDAO {

	List<User> getGroomByCity(String logincity);
	List<User> getRecentlyaddedMember();
	
}
