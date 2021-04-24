package com.example.vipcube.spring.batch.step;

import com.example.vipcube.spring.batch.vo.Bike;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class BikeItemProcessor implements ItemProcessor<Bike, Bike> {
	private String key;

	@BeforeStep
	public void beforeStep(final StepExecution stepExecution) {
		this.key = stepExecution.getJobParameters().getString( "key" );
	}

	@Override
	public Bike process( Bike bike ) throws Exception {
		bike.setCategory( bike.getBrand() + " " + bike.getAssetNo() );
		log.info( "BikeItem: {} and key: {}", bike.toString(), key );
		return bike;
	}
}
