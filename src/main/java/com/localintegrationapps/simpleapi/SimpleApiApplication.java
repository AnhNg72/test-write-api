package com.localintegrationapps.simpleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class SimpleApiApplication {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Updated Test Write API v6")
						.version("6.0")
						.description("Updated API documentation v6 for API that writes data to DB"));
	}

	public static void main(String[] args) {

		SpringApplication.run(SimpleApiApplication.class, args);
	}

}
