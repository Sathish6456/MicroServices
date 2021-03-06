package com.zensar.messageservice.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
@RefreshScope
public class MessageRestController {
	
	@Value("${organization}")
	private String company;

	@GetMapping()
	public String getMessage() 
	{
		return "Welcome to 		"+company;
	}
	
	@GetMapping("/{msg}")
	public String acceptMessage(@PathVariable String msg) 
	{
		return "Good Afternoon"+msg;
	}
	
}