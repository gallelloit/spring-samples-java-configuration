package com.gallelloit.spring.business;

import com.gallelloit.spring.service.FortuneService;

/**
 * Class with two plain properties (emailAddress and team) and a reference to FortuneService
 * The implementation for FortuneService is HappyFortuneService as a result of the Java config file.
 * 
 * @author pgallello
 *
 */
public class FootballCoach implements Coach {

	private String emailAddress;
	private String team;
	
	private FortuneService fortuneService;
	
	public FootballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return ">> Football coach: goalkeeper practice";
		
	}

	@Override
	public String getDailyFortune() {
		
		return ">> Football fortune: " + fortuneService.getFortune();
		
	}
	
}