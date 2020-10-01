package com.springboot.bhoivarvadhu.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.bhoivarvadhu.dto.User;

@Service
public interface RelatedCardsDAO {

	List<User> getGroomByCity(String logincity, String loginGroom_Bride);
	List<User> getRecentlyaddedMember(String loginGroom_Bride);
	
}
