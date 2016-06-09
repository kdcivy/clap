package com.ktds.framework.boot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class, HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@ComponentScan("com.ktds.framework.boot.config")
@Import({MainConfiguration.class})
public class Application extends SpringBootServletInitializer{
	private static Class<Application> applicationClass = Application.class;
	private static Logger logger = LoggerFactory.getLogger(Application.class);
 
    @Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub 
    	logger.info("==================[ 1. onStartup Start ]==================");
		super.onStartup(servletContext);
		logger.info("==================[ 1. onStartup End ]==================");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	logger.info("==================[ 2. SpringApplicationBuilder Start ]==================");
		return application.sources(applicationClass);
	}

    @Bean
    public DispatcherServlet dispatcherServlet(AnnotationConfigWebApplicationContext context) {
        return new DispatcherServlet(context);
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
    
    @Bean
    public ServletRegistrationBean dispatcherServletBean() {
    	logger.info("==================[ 3. Start ServletRegistrationBean ]==================");
    	
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(ServletContextConfiguration.class.getName());
        
        DispatcherServlet dispatcherServlet = dispatcherServlet(context);
    	
/*    	DispatcherServlet dispatcherServlet = dispatcherServlet();
    	
        XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
        applicationContext.setConfigLocation("classpath:/spring/appServlet/servlet-context-config.xml");
        dispatcherServlet.setApplicationContext(applicationContext);*/

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/");
        //ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/*");// JBoss Server 인 경우
        //servletRegistrationBean.setName("myDispatcherServlet");
        /*
         * The DispatcherServletAutoConfiguration.class will check if a bean named dispatchServlet exist in context, 
         * if it does it won't create one. So we will create a @Bean through java config named dispatchServlet to override the default. 
         * Next we create a bean that will return a ServletRegistrationBean. 
         * A ServletRegistrationBean is a class within spring-boot that allows you to register a servlet within the servlet 3.0 container 
         * but it wraps it in a Spring Bean friendly design otherwise you would have to work with ServletRegistration.Dynamic directly.
         */
        servletRegistrationBean.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        
        // initialize dispatcherServlet
        servletRegistrationBean.setLoadOnStartup(1);
        logger.info("==================[ 3. End ServletRegistrationBean ]==================");
        
        return servletRegistrationBean;
    }
    
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
      final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
      characterEncodingFilter.setEncoding("UTF-8");
      characterEncodingFilter.setForceEncoding(true);
      return characterEncodingFilter;
    }
    
	public static void main(String[] args) {
        ApplicationContext appCtx = SpringApplication.run(applicationClass, args);

		logger.info("----------------------- [main] Start SpringBootApplication -----------------------");
		//ApplicationContext appCtx = ctx.getApplicationContext();
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

/*		Environment env = appCtx.getEnvironment();
		for(Iterator it = ((AbstractEnvironment) env).getPropertySources().iterator(); it.hasNext(); ) {
			PropertySource propertySource = (PropertySource) it.next();
			if (propertySource instanceof MapPropertySource) {
				MapPropertySource ms = (MapPropertySource)propertySource.getSource();
				Map<String,Object> map = ms.getSource();
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					logger.info("map key={}, value={}",entry.getKey(),entry.getValue());	
				}
			}
		}*/
		
		logger.info("spring.profiles.active=" + appCtx.getEnvironment().getProperty("spring.profiles.active"));
		logger.info("log4j.configurationFile=" + appCtx.getEnvironment().getProperty("log4j.configurationFile"));
		logger.info("logback.configurationFile=" + appCtx.getEnvironment().getProperty("logback.configurationFile"));
		logger.info("logs.dir=" + appCtx.getEnvironment().getProperty("logs.dir"));
		logger.info("app.name=" + appCtx.getEnvironment().getProperty("app.name"));
		logger.info("apServer.type=" + appCtx.getEnvironment().getProperty("apServer.type"));
		
		logger.info("----------------------- [main] End SpringBootApplication -----------------------");
    }
}