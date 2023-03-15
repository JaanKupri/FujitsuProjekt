package com.example.fujitsu;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class FujitsuApplication {

	Logger logger = (Logger) LoggerFactory.getLogger(FujitsuApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FujitsuApplication.class, args);
	}

	@Scheduled(fixedDelayString = "PT1H", initialDelay = 2000L)
	public void ScheduleHourly() throws InterruptedException {
		logger.info("Current time" + new Date());
		Thread.sleep(59*60*1000);
	}

}
