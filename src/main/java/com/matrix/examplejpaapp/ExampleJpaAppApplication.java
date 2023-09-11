package com.matrix.examplejpaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class ExampleJpaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleJpaAppApplication.class, args);

	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(ExampleJpaAppApplication.class);
//	}

}
