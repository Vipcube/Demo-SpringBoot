package com.example.vipcube.spring.batch.config;

import com.example.vipcube.spring.batch.step.BikeItemProcessor;
import com.example.vipcube.spring.batch.vo.Bike;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class BatchJobConfiguration {
	public final JobBuilderFactory jobBuilderFactory;
	public final StepBuilderFactory stepBuilderFactory;

	@Autowired
	public BatchJobConfiguration( JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory ){
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public FlatFileItemReader<Bike> reader() {
		return new FlatFileItemReaderBuilder<Bike>()
				.name("bikeReader")
				.resource(new ClassPathResource("csv/Bike.csv"))
				.delimited()
				.names(new String[]{"brand","assetNo"})
				.fieldSetMapper( new BeanWrapperFieldSetMapper<>() {{
					setTargetType( Bike.class );
				}})
				.build();
	}

	@Bean
	public BikeItemProcessor processor() {
		return new BikeItemProcessor();
	}

	@Bean
	public FlatFileItemWriter<Bike> writer() {
		return new FlatFileItemWriterBuilder<Bike>()
				.name("bikeWriter")
				.resource(new FileSystemResource("target/test-outputs/output.csv"))
				.lineAggregator(new PassThroughLineAggregator<>())
				.build();
	}

	@Bean
	public Job testJob(Step step) {
		return jobBuilderFactory.get("testJob")
				.start(step)
				.build();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get("step")
				.<Bike, Bike> chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
}
