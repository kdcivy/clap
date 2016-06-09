package com.ktds.framework.boot;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class SubJdbcProfile {
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ppasDataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ppasDataSource);
		return jdbcTemplate;
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource ppasDataSource) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ppasDataSource);
		return namedParameterJdbcTemplate;
	}
}