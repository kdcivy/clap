package com.ktds.framework.boot.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
@Profile("staging")
public class StagingDataSourceConfig {
	private static Logger logger = LoggerFactory.getLogger(StagingDataSourceConfig.class);
	
    @Value("${datasource.db-ppas.jndi}")
    private String ppasJndiName;
	
	@Bean(name="ppasDataSource",destroyMethod="")
	@Primary
	//@ConfigurationProperties(prefix="datasource.db-ppas")
	public DataSource primaryJndiDataSource() {
		logger.info("==================[ staging primaryJndiDataSource Start ]==================");
		logger.info("ppasJndiName={}",ppasJndiName);
	    JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
	    DataSource dataSource = dataSourceLookup.getDataSource(ppasJndiName);
		logger.info("==================[ staging primaryJndiDataSource End ]==================");
		
	    return dataSource;
	}
}
