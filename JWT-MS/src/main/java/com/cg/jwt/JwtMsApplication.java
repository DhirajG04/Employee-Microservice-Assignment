package com.cg.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JwtMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtMsApplication.class, args);
	}

}
