package com.zensar.messageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
/*
 * @EnableEurekaClient writing this annotation on top of eureka Client is
 * optional Just having dependency automatically registers this client with Eureka 
 * 
 * <dependency> 
 * 		<groupId>org.springframework.cloud</groupId>
 * 		<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
 * </dependency>
 * 
 * It is recommended to annotate client with @EnableEurekaClient to improve readability
 * 
 * @EnableEurekaClient-this annotation is specific to netflix hence client code gets tightly coupled to netflix
 * 
 *  we should use standard annotation
 *  
 *  @EnableDiscoveryClient-this annotation is given by spring cloud
 *  
 *  It is recommended to annotate client with @EnableDiscoveryClient to improve readability and avoid tight coupling
 */

//@EnableEurekaClient
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
