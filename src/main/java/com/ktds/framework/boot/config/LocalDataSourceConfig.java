package com.ktds.framework.boot.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalDataSourceConfig {
	private static Logger logger = LoggerFactory.getLogger(LocalDataSourceConfig.class);
    
	@Bean(name="ppasDataSource")
	@Primary
	@ConfigurationProperties(prefix="datasource.db-ppas")
	public DataSource localDataSource() {
		logger.info("==================[ local DataSourceBuilder Start ]==================");
		DataSourceBuilder db = DataSourceBuilder.create();
		db.driverClassName("org.apache.commons.dbcp.BasicDataSource");
		logger.info("==================[ local DataSourceBuilder End ]==================");
		
		return db.build();
		//return DataSourceBuilder.create().build();
	}
}
