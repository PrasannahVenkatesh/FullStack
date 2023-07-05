package com.fullstack.FullStackdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.fullstack.controller.FullStackController;
import com.fullstack.service.FullStackService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {FullStackController.class,FullStackService.class})
@EnableMongoRepositories("com.fullstack.repository")
public class FullStackdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackdemoApplication.class, args);
	}

}
