package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cg.entity.Token;
import com.cg.repository.SlotRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories("com.cg.repository")
@EntityScan("com.cg.entity")
@EnableSwagger2
public class CarParkingSytstemApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(CarParkingSytstemApplication.class, args);
		
	}

}
