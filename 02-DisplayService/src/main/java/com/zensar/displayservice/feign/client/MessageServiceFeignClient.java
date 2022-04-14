package com.zensar.displayservice.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * approach-1
 * Here @FeignClient(value = "messageservice")-value is name of Message microservice as registered with Eureka
 * below approach microservices are directly communicating with each other
 * 
 * approach-2
 * We want any communication among microservices through API gateways
 */
@FeignClient(value = "apigateway")
public interface MessageServiceFeignClient {
	
	/*
	 * following method signature MUST match with signature of service method we are intrested in calling
	 *In our case this method signature MUST match with MessageRestController -getMessage() method
	 *
	 *Following method can be named anything 
	 *
	 *Approach1
	 *URL pattern written here must be URL pattern of generateMessage() method
	 *@GetMapping(path="/api/message")
	 *
	 *Approach2
	 *@GetMapping(path="messageservice/api/message")- here first part of the url is anme of microservice 
	 *											second part of URL is 	URL pattern of generateMessage() method of microservice
	 *
	 */
	
	@GetMapping("/api/message")
	public String callgetMessage();

	
	@GetMapping("/api/message/{msg}")
	public String acceptMessage(@PathVariable String msg);


}
