package com.sandesh.springmvcboot;

import org.aspectj.lang.annotation.After;
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
	
	@After("execution(public * com.sandesh.springmvcboot.AlienRestController.getAliens())")
	public void logAfter() {
		LOGGER.info("After getAliens method called from aspect");
	}

}
