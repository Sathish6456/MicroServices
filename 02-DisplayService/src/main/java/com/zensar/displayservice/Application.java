package com.zensar.displayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @EnableFeignClients-Is MUST on top of feign client classes to enable feign client,otherwise Feign won't work
 * 
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.zensar.displayservice.feign.client")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
