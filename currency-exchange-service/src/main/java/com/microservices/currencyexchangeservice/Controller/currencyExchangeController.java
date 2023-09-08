package com.microservices.currencyexchangeservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.POJO.CurrencyExchange;
import com.microservices.currencyexchangeservice.Repository.CurrencyExchangeRepo;

@RestController
public class currencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepo currencyExchangeRepo;
	
	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange rerieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		CurrencyExchange currencyExchange=currencyExchangeRepo.findByFromAndTo(from, to);
		if(currencyExchange==null) {
			throw new RuntimeException("unable to find record for "+ from +" to "+to);
		}
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
	
}
