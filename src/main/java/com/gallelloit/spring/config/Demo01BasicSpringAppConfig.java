package com.gallelloit.spring.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.gallelloit.spring.business.Coach;
import com.gallelloit.spring.business.CricketCoach;
import com.gallelloit.spring.service.FortuneService;
import com.gallelloit.spring.service.RandomFortuneService;

/**
 * 
 * Java config configuration file. It defines a Bean for the FortuneService implementation (in this case
 * RandomFortuneService) and another Bean for the Coach implementation (CricketCoach). It uses the CricketCoach
 * constructor to inject the randomFortuneService bean.
 * 
 * @author pgallello
 *
 */
@Configuration
@PropertySource("sport.properties")
public class Demo01BasicSpringAppConfig {
	
	@Bean
	public FortuneService randomFortuneService() {
		
		return new RandomFortuneService();
		
	}
	
	@Bean
	public Coach cricketCoach() {
		
		CricketCoach cricketCoach = new CricketCoach( randomFortuneService() );
		
		return cricketCoach;
		
	}

}
