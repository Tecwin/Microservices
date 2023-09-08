package com.microservices.currencyexchangeservice.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {

	private Logger logger=LoggerFactory.getLogger(CircuitBreakerController.class); 
	
	@GetMapping("/sample-api")
//	@Retry(name="sample-api",fallbackMethod="hardCodeResponse")
//	@CircuitBreaker(name="default",fallbackMethod="hardCodeResponse")
	@RateLimiter(name="default" )
	public String SampleApi() {
		logger.info("sample api call recieved ");
//	 ResponseEntity<String> responseEntity=	new RestTemplate().getForEntity("http:localhost:8000/failure-api", String.class);
//	 
//		return responseEntity.getBody();
		return "api sample";
	}
	
	private String hardCodeResponse(Exception e) {
		return "fallback response";
	}
	
}
