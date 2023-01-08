package io.github.stevekordon.javafxspringbootexample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import io.github.stevekordon.javafxspringbootexample.JavaFxExampleApplication.StageReadyEvent;

import java.io.IOException;

/**
 * The stage initializer.
 * 
 * @author Steve Kordon
 */
@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent>
{
	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger(StageInitializer.class);
	
	/**
	 * The stage title.
	 */
	private static final String STAGE_TITLE = "Example";
	
	/**
	 * The application context.
	 */
	@Autowired
	private ApplicationContext applicationContext;
	
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(StageReadyEvent event)
	{
		try
		{
			// Get the stage
			Stage stage = event.getStage();

			// Load the FXML
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
			fxmlLoader.setControllerFactory(applicationContext::getBean);
			Parent root = fxmlLoader.load();
			
			// Get the scene
			Scene scene = new Scene(root);

			// Show the scene
			stage.setTitle(STAGE_TITLE);
			stage.setScene(scene);
			stage.show();
		}
		
		catch (IOException e)
		{
			LOGGER.error(e.getMessage(), e);
			
			throw new RuntimeException(e);
		}
	}
}
