package io.github.stevekordon.javafxspringbootexample;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Spring Boot Example Application Class.
 * This is the class used to run the application.
 *
 * @author Steve Kordon
 */
@SpringBootApplication
public class SpringBootExampleApplication
{
	/**
	 * The main method.
	 *
	 * @param args The args.
	 */
	public static void main(String[] args)
	{
		Application.launch(JavaFxExampleApplication.class, args);
	}
}
