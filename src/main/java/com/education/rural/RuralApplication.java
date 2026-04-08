package com.education.rural;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition(
		info = @Info(
				title = "Rural School Management API",
				version = "1.0.0",
				description = "REST API for managing rural schools and academic resources",
				contact = @Contact(
						name = "Ronald I. Castro G.",
						url = "https://www.linkedin.com/in/ronaldcastro-tech"
				)
		)
)
public class RuralApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuralApplication.class, args);
	}

}
