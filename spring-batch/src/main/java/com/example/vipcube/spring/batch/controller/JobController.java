package com.example.vipcube.spring.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
	@Autowired
	JobLauncher jobLauncher;

	@Autowired Job testJob;

	@GetMapping( value = { "/run/{path}" } )
	public ResponseEntity<?> run( @PathVariable String path ) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException,
			JobParametersInvalidException, JobRestartException {
		jobLauncher.run(testJob, new JobParametersBuilder()
				.addString( "key", path )
				.toJobParameters());
		return ResponseEntity.ok( "OK" );
	}
}
