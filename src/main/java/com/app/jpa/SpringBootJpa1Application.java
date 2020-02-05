package com.app.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootJpa1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpa1Application.class, args);
	}

}
