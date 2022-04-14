package com.zensar.apigateway.filter;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

//Global Filter is an interface given by API gateway
@Configuration
public class CustomFilter implements GlobalFilter{

	/*
	 * Following method is oppertinity for us do some pre-processing
	 * This method automatically executes
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("in filter doing preprocessing");
		//pre-processing logic 
		//After successfull pre-processing this method MUST call filter() method on chain Object
		ServerHttpRequest request=exchange.getRequest();
		HttpHeaders headers=request.getHeaders();
		List<String> list=headers.get("Authorization");
		if(list !=null) {
			String authorizationHeaderValue=list.get(0);
	
		if(authorizationHeaderValue==null) {
			//Pre-processing logic fails then don't allow reqyest to proceed 
			ServerHttpResponse response=exchange.getResponse();
			response.setStatusCode(HttpStatus.UNAUTHORIZED);
			return response.setComplete();
		}
		}
		else {
			//Pre-processing logic fails then don't allow reqyest to proceed 
			ServerHttpResponse response=exchange.getResponse();
			response.setStatusCode(HttpStatus.UNAUTHORIZED);
			return response.setComplete();
		}
		//After successful pre-processing this method MUSTcall filter() method on chain Object
		return chain.filter(exchange);
	}

}
