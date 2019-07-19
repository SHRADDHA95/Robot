package com.robotservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.robotservice.service.RobotService;

@SpringBootApplication
public class RobotServiceApplication implements CommandLineRunner {
	@Autowired
	private RobotService robotService;
	public static void main(String[] args) {
		SpringApplication.run(RobotServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		//robotService.walkingWithWeight(5.5, 0.0);
		robotService.walkingWithWeight(2.0, 3.0);
		//robotService.walkingWithWeight(0.0, 12.0);
		//Asuming QR code return integer value as 0 or 1
		robotService.displayPrice("hhs77fsfdu8dh");
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
