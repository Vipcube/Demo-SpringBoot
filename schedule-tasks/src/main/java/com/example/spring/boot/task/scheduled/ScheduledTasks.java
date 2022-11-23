package com.example.spring.boot.task.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * The demo of scheduled tasks.
 *
 * @author Brad Chen
 *
 */
@Slf4j
@Component
public class ScheduledTasks {

	/**
	 * The test scheduled task of cron-expression.
 	 */
	@Scheduled( cron = "${demo.scheduled.task:0 */5 * * * *}" )
	public void testCronExpression(){
		log.info( "Cron Expression: The time is now {}", new Date() );
	}
}
