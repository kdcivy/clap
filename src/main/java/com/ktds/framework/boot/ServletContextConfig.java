package com.ktds.framework.boot;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

@Configuration
@EnableWebMvc
@ComponentScan(
		basePackages="com.ktds.framework",
		useDefaultFilters=false,
		includeFilters={
			@ComponentScan.Filter(type=FilterType.ANNOTATION, value=Controller.class),
			@ComponentScan.Filter(type=FilterType.ANNOTATION, value=ControllerAdvice.class)
		}
	)

public class ServletContextConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ApplicationContextHolder applicationContextHolder() {
		ApplicationContextHolder applicationContextHolder = new ApplicationContextHolder();
		return applicationContextHolder;
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(false);
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
		configurer.mediaType("text", MediaType.TEXT_PLAIN);
		configurer.mediaType("html", MediaType.TEXT_HTML);
		configurer.mediaType("json", MediaType.APPLICATION_JSON);
		configurer.mediaType("xml", MediaType.APPLICATION_XML);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
		List<MediaType> list = new ArrayList<MediaType>(); 
		list.add(new MediaType("text", "plan", Charset.forName("UTF-8")));
		stringHttpMessageConverter.setSupportedMediaTypes(list);
		converters.add(stringHttpMessageConverter);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/sample/**").addResourceLocations("/sample/");
    	registry.addResourceHandler("/app/**").addResourceLocations("/app/");
    	registry.addResourceHandler("/ng-grid/**").addResourceLocations("/ng-grid-app/");
 	}
		
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager contentNegotiationManager) {
		ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		contentNegotiatingViewResolver.setOrder(1);
		contentNegotiatingViewResolver.setContentNegotiationManager(contentNegotiationManager);
		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
		viewResolvers.add(new BeanNameViewResolver());
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		viewResolvers.add(internalResourceViewResolver);
		contentNegotiatingViewResolver.setViewResolvers(viewResolvers);
		
		List<View> views = new ArrayList<View>();		

		MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
		mappingJackson2JsonView.setPrettyPrint(true);
		
		XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
		xStreamMarshaller.setAutodetectAnnotations(true);
		xStreamMarshaller.setSupportedClasses(java.util.List.class, java.lang.String.class, com.ktds.framework.sample.mybatis.domain.Employee.class);
		MarshallingView marshallingView = new MarshallingView(xStreamMarshaller);

		views.add(mappingJackson2JsonView);
		views.add(marshallingView);
		
		contentNegotiatingViewResolver.setDefaultViews(views);
		return contentNegotiatingViewResolver;
	}
}
