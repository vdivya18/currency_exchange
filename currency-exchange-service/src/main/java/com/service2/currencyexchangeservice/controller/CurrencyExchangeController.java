package com.service2.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.service2.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveValue(@PathVariable String from,@PathVariable String to) {
		
		//CurrencyExchange exchange= new CurrencyExchange(1000l,from,to,BigDecimal.valueOf(80));
		CurrencyExchange exchange= repository.findByFromAndTo(from,to);
		if(exchange==null) {
			throw new RuntimeException("No exchange");
		}
		String port=environment.getProperty("local.server.port");
		exchange.setEnvironment(port);
		return exchange; 
		
	}

}
