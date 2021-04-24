package com.example.vipcube.spring.batch.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration extends DefaultBatchConfigurer {
	@Override
	public void setDataSource( DataSource dataSource) {
		// use batch without any DataSource
	}
}
