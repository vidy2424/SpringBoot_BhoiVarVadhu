package com.springboot.bhoivarvadhu.dao;

import org.springframework.stereotype.Service;

import com.springboot.bhoivarvadhu.dto.Info;

@Service
public interface InfoDAO {

	
	boolean add(Info info);
}
