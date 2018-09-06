package com.gallelloit.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.gallelloit.spring.business.Coach;
import com.gallelloit.spring.business.TrackCoach;
import com.gallelloit.spring.service.FortuneService;
import com.gallelloit.spring.service.RandomFortuneService;

/**
 * 
 * Java config configuration file. It defines a Bean for the FortuneService implementation (in this case
 * RandomFortuneService) and another Bean for the Coach implementation (CricketCoach). It uses the CricketCoach
 * constructor to inject the randomFortuneService bean.
 * 
 * Additionally, for lifecycle testing purposes, the TrackCoach Bean defines the methods that will have to be
 * executed after construction and before destroy.
 * 
 * @author pgallello
 *
 */
@Configuration
@PropertySource("sport.properties")
public class Demo02LifeCycleSpringAppConfig {
	
	@Bean
	public FortuneService randomFortuneService() {
		
		return new RandomFortuneService();
		
	}
	
	@Bean(initMethod="initMethod", destroyMethod="destroyMethod")
	public Coach trackCoach() {
		
		TrackCoach trackCoach = new TrackCoach( randomFortuneService() );
		
		return trackCoach;
		
	}

}
