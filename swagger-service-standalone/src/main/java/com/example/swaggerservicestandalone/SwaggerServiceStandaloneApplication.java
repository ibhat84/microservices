package com.example.swaggerservicestandalone;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Annual Day Participants"))
@EnableDiscoveryClient
public class SwaggerServiceStandaloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerServiceStandaloneApplication.class, args);
	}

	@Bean
	ForwardedHeaderFilter forwardedHeaderFilter() {
		return new ForwardedHeaderFilter();
	}

}
