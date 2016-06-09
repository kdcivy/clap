package com.ktds.framework.boot.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:/properties/local/ppas-db.properties")
public class SingleDataSourceConfig {
	private static Logger logger = LoggerFactory.getLogger(SingleDataSourceConfig.class);
	
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    
    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean(name="ppasDataSource")
    @Profile("local-singleDS")
    public DataSource localDataSource() {
    	logger.info("==================[ SingleDataSourceConfig Start ]==================");
    	logger.info("driverClassName={}, url={}, username={}, password={}",driverClassName,url,username,password);

    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName(driverClassName);
    	dataSource.setUrl(url);
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);

    	logger.info("==================[ SingleDataSourceConfig End ]==================");
    	
    	return dataSource;
        //return new DriverManagerDataSource(url, username, password);
    }

    @Bean(name="ppasDataSource")
    @Profile("dev-singleDS")
    public DataSource developmentDataSource() {
    	
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(driverClassName);
    	dataSource.setUrl(url);
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
        
    	return dataSource;
    }
    
    @Bean(name="ppasDataSource")
    @Profile("prod-singleDS")
    public DataSource productionDataSource() throws Exception {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/ppasDataSource");
    }

}
