package com.ktds.framework.boot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(
	basePackages="com.ktds.framework.sample",
	useDefaultFilters=false,
	includeFilters={
		@ComponentScan.Filter(type=FilterType.ANNOTATION, value=Service.class),
		@ComponentScan.Filter(type=FilterType.ANNOTATION, value=Repository.class)
	}
)

public class RootContextMultipleConfig {

	@Bean(name="ppas")
	public DataSourceTransactionManager ppasTransactionManager(DataSource ppasDataSource) {
		DataSourceTransactionManager ppasTransactionManager = new DataSourceTransactionManager();
		ppasTransactionManager.setDataSource(ppasDataSource);
		return ppasTransactionManager;
	}

	@Bean(name="mysql")
	public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlDataSource") DataSource mysqlDataSource) {
		DataSourceTransactionManager mysqlTransactionManager = new DataSourceTransactionManager();
		mysqlTransactionManager.setDataSource(mysqlDataSource);
		return mysqlTransactionManager;
	}
}
