package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BackgroundTasks {

	/**
	 * Approach1: We can inject/access the property some.millis directly in @Value
	 * fashion even though we have configured it to bind with SomeProperties class
	 * using @ConfigurationProperties.
	 */
	@Scheduled(fixedRateString = "${some.millis}")
	public void fromDirectInjection() {

		System.out.println("Hi, I'm  from DirectInjection method");

	}

	/**
	 * Approach2: Add @Component on SomeProperties and access the bean bean's
	 * property millis like below using Spring Expression language
	 */
	@Scheduled(fixedRateString = "#{@someProperties.millis}")
	public void fromConfigurationProperty() {
		System.out.println("Hi, I'm from ConfigurationProperty method");

	}

	/**
	 * https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config.typesafe-configuration-properties.enabling-annotated-types
	 *
	 *  When the @ConfigurationProperties bean is registered using configuration property scanning or
	 *  via @EnableConfigurationProperties, the bean has a conventional name: <prefix>-<fqn>,
	 *  where <prefix> is the environment key prefix specified in the @ConfigurationProperties annotation
	 *  and <fqn> is the fully qualified name of the bean. If the annotation does not provide any prefix,
	 *  only the fully qualified name of the bean is used.
	 *
	 */
	@Scheduled(fixedRateString = "#{@'other-com.example.demo.OtherProperties'.millis}")
	public void fromImmutableConfigurationProperties() {
		System.out.println("Hi, I'm from immutable @ConstructorBinding properties");
	}

}
