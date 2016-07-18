package io.egen;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ApplicationContextProvider implements ApplicationContextAware{

	private static ApplicationContext applicationContext = new GenericXmlApplicationContext("spring-configuration.xml");

	 @ExceptionHandler(Exception.class)
	 public static ApplicationContext getApplicationContext() {
		return applicationContext;
	 }
	 
	 @ExceptionHandler(Exception.class)
	 public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			 ApplicationContextProvider.applicationContext = applicationContext;
	 }
}
