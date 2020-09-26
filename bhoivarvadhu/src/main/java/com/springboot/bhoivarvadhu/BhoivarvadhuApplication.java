package com.springboot.bhoivarvadhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

 
@SpringBootApplication
@EnableScheduling

@ComponentScan(basePackages = { "com.springboot.bhoivarvadhu.*", "com.springboot.bhoivarvadhu.config" })
public class BhoivarvadhuApplication extends SpringBootServletInitializer {

	@Bean 
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean    
	RedisTemplate<String, String> redisTemplate() {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BhoivarvadhuApplication.class);
	}

	 
	public static void main(String[] args) {
		SpringApplication.run(BhoivarvadhuApplication.class, args);
	}

}
