package com.trip.mukja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.trip.mukja"})
@EnableSwagger2
public class MukjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MukjaApplication.class, args);
	}

}
