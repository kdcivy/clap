package com.ktds.framework.boot;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableJpaRepositories("com.ktds.framework.sample.jpa")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "jpaEmf", 
        transactionManagerRef = "jpa",
        basePackages = {"com.ktds.framework.sample.jpa"})
public class SubJpaProfile {

	@Bean
	public LocalContainerEntityManagerFactoryBean jpaEmf(DataSource ppasDataSource) {
		LocalContainerEntityManagerFactoryBean jpaEmf = new LocalContainerEntityManagerFactoryBean();
		jpaEmf.setDataSource(ppasDataSource);
		jpaEmf.setPackagesToScan("com.ktds.framework.sample.jpa");
		jpaEmf.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		jpaEmf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		jpaEmf.setJpaPropertyMap(map);
		return jpaEmf;
	}

	@Bean(name="jpa")
	public JpaTransactionManager jpaTxManager(LocalContainerEntityManagerFactoryBean jpaEmf) throws Exception {
		JpaTransactionManager jpaTxManager = new JpaTransactionManager();
		jpaTxManager.setEntityManagerFactory(jpaEmf.getObject());
		return jpaTxManager;
	}
}
