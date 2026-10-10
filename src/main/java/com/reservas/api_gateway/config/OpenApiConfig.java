package com.reservas.api_gateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI gatewayOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("API Gateway — Tutoring reservations")
						.version("1.0.0")
						.description("Use the dropdown to switch between ms-users and ms-availability OpenAPI definitions."));
	}
}
