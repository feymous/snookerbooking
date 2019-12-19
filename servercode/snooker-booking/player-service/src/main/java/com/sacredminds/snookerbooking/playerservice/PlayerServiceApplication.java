package com.sacredminds.snookerbooking.playerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.sacredminds.snookerbooking.*")
@EnableJpaRepositories(basePackages = "com.sacredminds.snookerbooking.*")
@EnableAutoConfiguration
@EntityScan(basePackages = "com.sacredminds.snookerbooking.*")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class PlayerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerServiceApplication.class, args);
	}
}
