# spring-samples-java-config
Plain and simple Spring samples using Java Configuration File

# Configuration

* Spring 5.8.0

# Use case

Simple and plain Spring samples repository that uses main java classes to test each case.
It includes basic functionality:

* Creating and retrieving beans
* Bean Lifecycle
* Bean Scope

# Getting started

To get this Maven project working:

* Clone this repo
* Build using Maven
* In your IDE, get to the com.gallelloit.springdemo.main package, and execute each of the proposed Demo Main Apps
* Play around
  
# Proposed Demo Main Apps

## Demo01BasicSpringJavaConfigurationApp.java:

Simple Spring application that creates a context from a Java configuration file (Demo01BasicSpringAppConfig),
which explicitly configures the beans to be used.

This app gets the bean cricketCoach, which implements the interface Coach. This coach implementation uses internally
the implementation RandomFortuneService of interface FortuneService, as set up in the configuration file.

The values of the plain private properties in CricketCoach implementation are fetched from sports.properties
This configuration is specified in the configuration file with the annotation @PropertySource("sport.properties")

With that set up, in the bean itself, i.e., in the class definition, a @Value annotation is used on each property:

```
		@Value(value="${foo.email}")
		private String emailAddress;
	
		@Value(value="${foo.team}")
		private String team;
```

## Demo02LifeCycleJavaConfigurationApp.java:
 
Simple Spring application that creates a context from a Java configuration file (Demo02LifeCycleSpringAppConfig),
which explicitly creates the beans to be used.

This app gets the bean trackCoach, which implements the interface Coach. This coach implementation uses internally
the implementation RandomFortuneService of interface FortuneService, as specified in the Java configuration file.

This demo application tests the lifecycle of Spring beans. The Java configuration file defines what methods must be
executed right after the construction of the Bean and before the destroy. This is particularly specified in the
initMethod and destroyMethod fields of the @Bean annotation:

`@Bean(initMethod="initMethod", destroyMethod="destroyMethod")`

## Demo03BeanScopeJavaConfigurationApp.xml

Simple Spring application that creates a context from a Java configuration file (Demo03BeanScopeSpringAppConfig),
which explicitly configures the beans to be used.

It gets the bean footballCoach, which implements the interface Coach
This Coach implementation uses internally the implementation HappyFortuneService of interface FortuneService
as set up in the Java configuration file.

The resolved issue of this example is testing the two most used bean scopes from Spring: Singleton and Prototype

In the FootballCoach object, two alternative versions of the bean definition are specified through the
@Scope annotation in the Java configuration file. It must be specified with the scope strategy. The original proposed solution
has both alternative lines, one of which must be commented.

- On one side, Singleton (`@Scope(value="singleton")`), the default strategy, will make Spring to create and
return one instance of the bean no matter how many times the bean is retrieved. You can see in the example how
the memory location for the two retrieved objects is the same.

- Whereas when Prototype strategy is defined (`@Scope(value="prototype")`), any time a new bean is requested to the container, a different
instance is created and retrieved. This test can be performed commenting the singleton line and uncommenting
the prototype one.
