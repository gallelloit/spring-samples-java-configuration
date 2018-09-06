package com.gallelloit.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gallelloit.spring.business.Coach;
import com.gallelloit.spring.business.FootballCoach;
import com.gallelloit.spring.service.FortuneService;
import com.gallelloit.spring.service.RandomFortuneService;

/**
 * 
 * Java config configuration file. It defines a Bean for the FortuneService implementation (in this case
 * RandomFortuneService) and another Bean for the Coach implementation (CricketCoach). It uses the CricketCoach
 * constructor to inject the randomFortuneService bean.
 * 
 * Additionally, for Bean scope testing purposes, the FootballCoach Bean defines allows to define the scope as
 * "singleton" or "prototype".
 * 
 * Uncomment the desired line to check each behavior.
 * 
 * @author pgallello
 *
 */
@Configuration
public class Demo03BeanScopeSpringAppConfig {
	
	@Bean
	public FortuneService happyFortuneService() {
		
		return new RandomFortuneService();
		
	}
	
	@Bean
	@Scope(value="singleton")
	//@Scope(value="prototype")
	public Coach footballCoach() {
		
		FootballCoach footballCoach = new FootballCoach( happyFortuneService() );
		
		return footballCoach;
		
	}

}
