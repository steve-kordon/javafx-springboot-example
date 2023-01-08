package io.github.stevekordon.javafxspringbootexample;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * The JavaFX Example Application Class.
 *
 * @author Steve Kordon
 */
public class JavaFxExampleApplication extends Application
{
	/**
	 * The application context.
	 */
	private ConfigurableApplicationContext applicationContext;


	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#init()
	 */
	@Override
	public void init()
	{
		ApplicationContextInitializer<GenericApplicationContext> initializer = ac ->
		{
			ac.registerBean(Application.class, () -> JavaFxExampleApplication.this);
			ac.registerBean(Parameters.class, () -> getParameters());
			ac.registerBean(HostServices.class, () -> getHostServices());
		};

		applicationContext = new SpringApplicationBuilder()
				.sources(SpringBootExampleApplication.class)
				.initializers(initializer)
				.run(getParameters().getRaw().toArray(new String[0]));
	}


	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		applicationContext.publishEvent(new StageReadyEvent(primaryStage));
	}


	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#stop()
	 */
	@Override
	public void stop()
	{
		applicationContext.stop();
		Platform.exit();
	}


	/**
	 * The stage ready event.
	 *
	 * @author Steve Kordon
	 *
	 */
	static class StageReadyEvent extends ApplicationEvent
	{
		/**
		 * The version UID.
		 */
		private static final long serialVersionUID = 3139905759546751006L;


		/**
		 * Object Constructor.
		 *
		 * @param stage The stage.
		 */
		public StageReadyEvent(Stage stage)
		{
			super(stage);
		}


		/**
		 * This method gets the stage.
		 *
		 * @return The stage.
		 */
		public Stage getStage()
		{
			return ((Stage) getSource());
		}
	}
}
