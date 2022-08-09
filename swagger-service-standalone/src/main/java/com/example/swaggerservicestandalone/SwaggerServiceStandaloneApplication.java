package com.example.swaggerservicestandalone;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Annual Day Participants"))
public class SwaggerServiceStandaloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerServiceStandaloneApplication.class, args);
	}

}
