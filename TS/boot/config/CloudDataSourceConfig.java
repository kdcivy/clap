package com.ktds.framework.boot.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"cloud"})
public class CloudDataSourceConfig extends AbstractCloudConfig{

	private static Logger logger = LoggerFactory.getLogger(CloudDataSourceConfig.class);

	@Bean(name="ppasDataSource")
	@Primary
	public DataSource ppasDataSource(){
		logger.info("==================[ ppasDataSource ]==================");
		return connectionFactory().dataSource("postgresql");
	}

	@Bean(name="mysqlDataSource")
	public DataSource mysqlDataSource(){
		logger.info("==================[ mysqlDataSource ]==================");
		return connectionFactory().dataSource("mysql");
	}
}
