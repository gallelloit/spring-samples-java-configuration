package com.gallelloit.spring.xml.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gallelloit.spring.business.Coach;
import com.gallelloit.spring.business.TrackCoach;
import com.gallelloit.spring.config.Demo02LifeCycleSpringAppConfig;

/**
 * Simple Spring application that creates a context from a Java configuration file (Demo02LifeCycleSpringAppConfig),
 * which explicitly creates the beans to be used.
 * 
 * This app gets the bean trackCoach, which implements the interface Coach. This coach implementation uses internally
 * the implementation RandomFortuneService of interface FortuneService, as specified in the Java configuration file.
 * 
 * This demo application tests the lifecycle of Spring beans. The Java configuration file defines what methods must be
 * executed right after the construction of the Bean and before the destroy. This is particularly specified in the
 * initMethod and destroyMethod fields of the @Bean annotation:
 * 
 * `@Bean(initMethod="initMethod", destroyMethod="destroyMethod")`
 * 
 * @author pgallello
 *
 */
public class Demo02LifeCycleJavaConfigApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo02LifeCycleSpringAppConfig.class);
		
		// Retrieve bean from Spring container
		Coach theCoach = context.getBean("trackCoach", TrackCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// Close context
		context.close();
	}

}
