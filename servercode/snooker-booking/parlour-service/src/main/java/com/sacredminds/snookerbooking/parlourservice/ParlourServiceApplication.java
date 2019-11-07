package com.sacredminds.snookerbooking.parlourservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ParlourServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParlourServiceApplication.class, args);
	}
}
