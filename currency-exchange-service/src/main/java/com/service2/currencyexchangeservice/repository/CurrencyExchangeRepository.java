package com.service2.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service2.currencyexchangeservice.controller.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange , Long >{
	
	 CurrencyExchange findByFromAndTo(String from,String to);

}
