package com.velocity.sports.odds_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OddsEngineApplication {

	 static void main(String[] args) {
		SpringApplication.run(OddsEngineApplication.class, args);
	}

}
