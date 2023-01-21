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
	 * The welcome text.
	 */
	private static final String WELCOME_TEXT = "Welcome to an example of a JavaFX Application with Spring Boot!";

	/**
	 * Simple method to prove loading
	 * the service worked.
	 *
	 * @return The welcome text.
	 */
	public String getWelcomeText()
	{
		return WELCOME_TEXT;
	}
}
