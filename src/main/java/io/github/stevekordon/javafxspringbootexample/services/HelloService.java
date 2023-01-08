package io.github.stevekordon.javafxspringbootexample.services;

import org.springframework.stereotype.Service;

/**
 * A service class.
 *
 * @author Steve Kordon
 */
@Service
public class HelloService
{
	/**
	 * Simple method to prove loading
	 * the service worked.
	 *
	 * @return The welcome text.
	 */
	public String getWelcomeText()
	{
		return "Welcome to an example of a JavaFX Application with Spring Boot!";
	}
}
