package com.ktds.framework.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@ImportResource("classpath:spring/appServlet/servlet-context-config.xml") // XML Configuration
public class ServletContextConfiguration extends WebMvcConfigurerAdapter{
/*    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/
}
