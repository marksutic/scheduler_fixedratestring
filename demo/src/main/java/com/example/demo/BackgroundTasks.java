package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BackgroundTasks {

	/**
	 * 
	 * Approach1: We can inject/access the property some.millis directly in @Value
	 * fashion even though we have configured it to bind with SomeProperties class
	 * using @ConfigurationProperties.
	 * 
	 * 
	 */
	@Scheduled(fixedRateString = "${some.millis}")
	public void fromDirectInjection() {

		System.out.println("Hi, I'm  from DirectInjection method");

	}

	/**
	 * 
	 * Approach2: Add @Component on SomeProperties and access the bean bean's
	 * property millis like below using Spring Expression language
	 * 
	 * 
	 */
	@Scheduled(fixedRateString = "#{@someProperties.millis}")
	public void fromConfigurationProperty() {
		System.out.println("Hi, I'm from ConfigurationProperty method");

	}

}
