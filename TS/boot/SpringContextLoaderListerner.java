package com.ktds.framework.boot;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/*
 * web.xml에 등록해야 동작함
 * <listener>
 * <listener-class>mypackage.SpringContextLoaderListerner</listener-class>
 * </listener>
 */
public class SpringContextLoaderListerner extends ContextLoaderListener{
	private static Logger logger = LoggerFactory.getLogger(SpringContextLoaderListerner.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		super.contextDestroyed(event);
		logger.debug("SpringContextLoaderListerner is destroyed.");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		super.contextInitialized(event);
		logger.debug("----------------------- Start contextInitialized -----------------------");

		// You can get Servelte Context 
		ServletContext servletContect = event.getServletContext();

		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContect);
		logger.debug(webApplicationContext.getDisplayName());
		// You can get any bean, which is defined in spring xml file here.
		//SomeClass someclass = (SomeClass) webApplicationContext.getBean("someclass");
		//someclass.doSomethingDuringStartup();
		logger.debug("----------------------- Start contextInitialized -----------------------");
	}

}
