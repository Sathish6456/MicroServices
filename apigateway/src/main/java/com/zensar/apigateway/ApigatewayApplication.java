package com.zensar.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/*
 * Api gateway works with eureka server to route requests to appropriate microservices 
 * Any common code which needs to be executed before or after every request to any microservice,
 * needs to be written here
 * Any request from client will be handled by api gateway
 * Also microservices internal communication also routed through API gateway
 * API gateway is itself  
 */
@SpringBootApplication
@EnableEurekaClient
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}

}
