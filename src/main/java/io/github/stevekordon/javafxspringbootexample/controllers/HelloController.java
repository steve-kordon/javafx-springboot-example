package io.github.stevekordon.javafxspringbootexample.controllers;

import io.github.stevekordon.javafxspringbootexample.services.HelloService;
import jakarta.annotation.Resource;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Component;

/**
 * A controller class.
 *
 * Important: The component attribute for spring.
 *
 * @author Steve Kordon
 */
@Component
public class HelloController
{
	/**
	 * The welcome text label from hello-view.fxml
	 */
	@FXML
	private Label welcomeText;

	/**
	 * The hello service.
	 */
	@Resource
	private HelloService helloService;


	/**
	 * The onHelloButtonClick call from hello-view.fxml
	 */
	@FXML
	protected void onHelloButtonClick()
	{
		welcomeText.setText(helloService.getWelcomeText());
	}
}