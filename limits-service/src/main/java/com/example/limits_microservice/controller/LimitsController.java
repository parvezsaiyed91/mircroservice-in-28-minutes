package com.example.limits_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.limits_microservice.bean.Limits;
import com.example.limits_microservice.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	Configuration config;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(config.getMinimum(), config.getMaximum());
	}
}
