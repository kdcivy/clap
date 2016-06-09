package com.ktds.framework.boot;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SubMybatisMultipleProfile {

	// PPAS Database 1 Configuration
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource ppasDataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setDataSource(ppasDataSource);
		sqlSessionFactoryBean.setConfigLocation(pmrpr.getResource("classpath:mybatisConfig.xml"));
		sqlSessionFactoryBean.setMapperLocations(pmrpr.getResources("classpath*:sqlMap/ppas/*.xml"));
		return sqlSessionFactoryBean;
	}
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.ktds.framework.sample.mybatis.persistence");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mapperScannerConfigurer;
	}
	
	@Bean(destroyMethod="clearCache")
	public SqlSessionTemplate mybatisSqlSession(@Qualifier("sqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception {
		SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSessionFactory);
		return sqlSession;
	}
	
	// MySQL Database 2 Configuration
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory2(@Qualifier("mysqlDataSource") DataSource mysqlDataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean2 = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver pmrpr2 = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean2.setDataSource(mysqlDataSource);
		sqlSessionFactoryBean2.setConfigLocation(pmrpr2.getResource("classpath:mybatisConfig.xml"));
		sqlSessionFactoryBean2.setMapperLocations(pmrpr2.getResources("classpath*:sqlMap/mysql/*.xml"));
		return sqlSessionFactoryBean2;
	}
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer2() {
		MapperScannerConfigurer mapperScannerConfigurer2 = new MapperScannerConfigurer();
		mapperScannerConfigurer2.setBasePackage("com.ktds.framework.sample.mysql");
		mapperScannerConfigurer2.setSqlSessionFactoryBeanName("sqlSessionFactory2");
		return mapperScannerConfigurer2;
	}
	
	@Bean(destroyMethod="clearCache")
	public SqlSessionTemplate mybatisSqlSession2(@Qualifier("sqlSessionFactory2")SqlSessionFactory sqlSessionFactory2) throws Exception {
		SqlSessionTemplate sqlSession2 = new SqlSessionTemplate(sqlSessionFactory2);
		return sqlSession2;
	}
}
