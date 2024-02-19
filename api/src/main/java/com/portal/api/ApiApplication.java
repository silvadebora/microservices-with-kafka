package com.portal.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {
	// api responsável por redirecionar o tráfego de informações para outros microservices
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
