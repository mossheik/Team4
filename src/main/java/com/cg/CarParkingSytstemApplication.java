package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cg.repository")
@EntityScan("com.cg.entity")
public class CarParkingSytstemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarParkingSytstemApplication.class, args);
	}

}
