package com.sandesh.springmvcboot;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.sandesh.springmvcboot.AlienRestController.getAliens())")
	public void logBefore() {
		LOGGER.info("Before getAliens method called from aspect");
	}
	
	// this method will be executed irrespective of the successful or exception return 
	@After("execution(public * com.sandesh.springmvcboot.AlienRestController.getAliens())")
	public void logAfterFinally() {
		LOGGER.info("Executed : AfterFinally getAliens method called from aspect");
	}
	
	// this method will be executed only when it has successful or no exception
	@AfterReturning("execution(public * com.sandesh.springmvcboot.AlienRestController.getAliens())")
	public void logAfter() {
		LOGGER.info("Successful : AfterReturning that is a normal return of getAliens method called from aspect");
	}
	
	// this method will be executed only when it has exception
	@AfterThrowing("execution(public * com.sandesh.springmvcboot.AlienRestController.getAliens())")
	public void logAfterException() {
		LOGGER.info("Issue : AfterException getAliens method called from aspect with some runtime issue");
	}

}
