package com.gallelloit.spring.business;

import com.gallelloit.spring.service.FortuneService;

/**
 * Simple class with a FortuneService property. It is set to the HappyFortuneService implementation as a result
 * of the Java config file
 * 
 * Display messages are shown for debug purposes to see when each method is executed by
 * Spring Framework at bean creation time.
 * 
 * @author pgallello
 *
 */
public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	/**
	 * Empty constructor. In the original demo app, it won't be executed
	 */
	public TrackCoach() {
		System.out.println(">> Track Coach: Inside empty constructor");
	}
	
	public TrackCoach(FortuneService theFortuneService) {
		System.out.println(">> Track Coach: Inside fortune constructor");
		fortuneService = theFortuneService; 
	}
	
	@Override
	public String getDailyWorkout() {
		return ">> Track coach: Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return ">> Track Fortune: " + fortuneService.getFortune();
	}
	
	// Init and destroy methods
	
	public void initMethod() {
		System.out.println(">> TrackCoach: inside init method");
	}

	public void destroyMethod() {
		System.out.println(">> TrackCoach: inside destroy method");
	}
	
}