package com.zensar.displayservice.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.displayservice.service.impl.DisplayServiceImpl;

@RestController
@RefreshScope
public class DisplayRestController 
{
	@Autowired
	private DisplayServiceImpl service;
	
	//Todo make necessary changes so that this property is accessible here "DisplayService"
	@Value("${organization}")
	private String company;
	
	@GetMapping("/api/display")
	public String displayMessages() 
	{
		String response=service.callGenerateMessage();
		System.out.println("In displayMessage "+response);
		return "Message From Message Service is "+response+ company;
		
		//RestTemplate rt = new RestTemplate();
		
		//In following call we are hardcoding IP and port of message service
		//If message service is deployed on other service (different IP)
		//This code is affected ,bad idea
		//we need a solution by which we can identify microservice with some "unique name"
		//Instead of Ip and port we will use "unique name" in our code
		//we have to register every microservice with some unique name.Where?
		//SPring cloud gives you a solution-Eureka Server(registry service)
		
		
		//In order to simplify Rest calls by using microservices application name
		//and avoid Ip and port spring cloud gives one solution known as--
		//open  feign
		
		//steps to use open feign
		//Add dependency in pom.xml
		
		//String response = rt.getForObject("http://localhost:8020/api/message", String.class);
		
		/*
		 * String response=feignClient.callgetMessage();
		 * Above call is making network call so it is risky,it might not work 
		 */
	}
	
//	@GetMapping("/{msg}")
//	public String displayInformation(@PathVariable String msg) 
//	{
//		return feignClient.acceptMessage(msg);
//	}

	
	
}
