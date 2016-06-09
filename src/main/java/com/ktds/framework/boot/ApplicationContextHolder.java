package com.ktds.framework.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHolder implements ApplicationContextAware{
	private static Logger logger = LoggerFactory.getLogger(ApplicationContextHolder.class);
	
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		// TODO Auto-generated method stub
		logger.info("==================[ ApplicationContextHolder Start ]==================");
		logger.info("applicationContext : " + ctx);
		logger.info("applicationContext hashCode : " + ctx.hashCode());
		logger.info("==================[ ApplicationContextHolder End ]==================");
	}

}
