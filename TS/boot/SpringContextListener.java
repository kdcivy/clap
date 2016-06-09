package com.ktds.framework.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class SpringContextListener implements ApplicationListener<ContextRefreshedEvent>{
	private static Logger logger = LoggerFactory.getLogger(SpringContextListener.class);
	
	public SpringContextListener(){
	    super();
	    logger.debug("SpringContextListener Application context listener is created!");
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("----------------------- Start SpringContextListener -----------------------");
		ApplicationContext appCtx = arg0.getApplicationContext();
		logger.info("Id=" + appCtx.getId() + ", displayName=" + appCtx.getDisplayName());
		
		// print profile info
		for(String prifile : appCtx.getEnvironment().getActiveProfiles()){
			logger.info("Active Profile=" + prifile);	
		}
		
		// print all loaded beans
		String[] beans = appCtx.getBeanDefinitionNames();
		for(String beanName : beans){
			logger.info("bean name=" + beanName);
		}
		
		// print system property
/*		Properties props = System.getProperties();
		props.list(System.out);*/

		logger.info("spring.profiles.active=" + appCtx.getEnvironment().getProperty("spring.profiles.active"));
		logger.info("log4j.configurationFile=" + appCtx.getEnvironment().getProperty("log4j.configurationFile"));
		logger.info("logback.configurationFile=" + appCtx.getEnvironment().getProperty("logback.configurationFile"));
		logger.info("logs.dir=" + appCtx.getEnvironment().getProperty("logs.dir"));
		logger.info("app.name=" + appCtx.getEnvironment().getProperty("app.name"));
		logger.info("apServer.type=" + appCtx.getEnvironment().getProperty("apServer.type"));
		
		logger.info("----------------------- End SpringContextListener -----------------------");
	}

}
