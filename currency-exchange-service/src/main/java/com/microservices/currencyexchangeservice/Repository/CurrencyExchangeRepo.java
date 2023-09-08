package com.microservices.currencyexchangeservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currencyexchangeservice.POJO.CurrencyExchange;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange,Integer>{
	CurrencyExchange findByFromAndTo(String from ,String to);

}
