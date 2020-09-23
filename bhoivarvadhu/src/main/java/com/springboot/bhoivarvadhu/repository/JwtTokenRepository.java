package com.springboot.bhoivarvadhu.repository;

import java.util.Map;

import com.springboot.bhoivarvadhu.dto.JwtInvalidToken;
  
public interface JwtTokenRepository {

    void save(String token);
    Map<String, String> findAll();
    String findById(String id);
    void update(JwtInvalidToken token);
    void delete(String id);
    boolean exist (String token);
}
