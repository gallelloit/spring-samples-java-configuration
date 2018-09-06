package com.gallelloit.spring.xml.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gallelloit.spring.business.CricketCoach;
import com.gallelloit.spring.config.Demo01BasicSpringAppConfig;

/**
 * Simple Spring application that creates a context from a Java configuration file (Demo01BasicSpringAppConfig),
 * which explicitly configures the beans to be used.
 * 
 * This app gets the bean cricketCoach, which implements the interface Coach. This coach implementation uses internally
 * the implementation RandomFortuneService of interface FortuneService, as set up in the configuration file.
 * 
 * The values of the plain private properties in CricketCoach implementation are fetched from sports.properties
 * This configuration is specified in the configuration file with the annotation @PropertySource("sport.properties")
 * 
 * With that set up, in the bean itself, i.e., in the class definition, a @Value annotation is used on each property:
 * 
 *  ```
 * 		@Value(value="${foo.email}")
 *		private String emailAddress;
 *	
 *		@Value(value="${foo.team}")
 *		private String team;
 *	```
 * 
 * @author pgallello
 *
 */
public class Demo01BasicSpringJavaConfigApp {

	public static void main(String[] args) {
		
		// Load the Spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo01BasicSpringAppConfig.class);

 		// Retrieve baseball coach object
		
		/*
		 * Java basics: if no implementation specific methods where used in this main program, it wouldn't be
		 * necessary to define the object with the implementation name. The next commented line shows how could
		 * be done:
		 * 
		 * Coach theCricketCoach = context.getBean("cricketCoach", Coach.class);
		 * 
		 */
		
		/*
		 * As long as implementation specific methods are used (getEmailAddress() and getTeam()), the object need to be created with the
		 * implementation name.
		 */
		CricketCoach theCricketCoach = context.getBean("cricketCoach", CricketCoach.class);
		
		// Call methods on the bean
		System.out.println(">> Main. Daily workout: " + theCricketCoach.getDailyWorkout());
		System.out.println(">> Main. Daily fortune: " + theCricketCoach.getDailyFortune());
		
		System.out.println(">> Main. Coach email address: " + theCricketCoach.getEmailAddress());
		System.out.println(">> Main. Coach team:" + theCricketCoach.getTeam());

		
		// Close the context
		context.close();
		
	}

}