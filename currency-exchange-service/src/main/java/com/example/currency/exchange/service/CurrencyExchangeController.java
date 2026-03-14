package com.example.currency.exchange.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment enviornment;
	
	@Autowired
	private CurrencyExchangeRepository currencyRepository;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to) {
//		CurrencyExchange currency = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(65));
		CurrencyExchange currency = currencyRepository.findByFromAndTo(from, to);
		if(currency ==null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
		}
		currency.setEnvironment(enviornment.getProperty("local.server.port"));
		return currency;
	}
}
