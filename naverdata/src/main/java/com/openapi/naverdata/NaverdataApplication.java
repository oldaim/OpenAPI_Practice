package com.openapi.naverdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NaverdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverdataApplication.class, args);
	}

}
