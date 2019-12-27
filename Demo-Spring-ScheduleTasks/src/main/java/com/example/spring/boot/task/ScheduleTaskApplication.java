package com.example.spring.boot.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The main program.
 *
 * @author Brad Chen
 *
 */
@EnableScheduling
@SpringBootApplication
public class ScheduleTaskApplication {
	public static void main( String[] args ) {
		SpringApplication.run( ScheduleTaskApplication.class, args );
	}
}
