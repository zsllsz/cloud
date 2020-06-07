package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderZkController {
	
	private static final String URL = "http://cloud-provider-payment";
	
	@Autowired
	public RestTemplate restTemplate; 
	
	@GetMapping("/info")
	public String paymentInfo() {
		return restTemplate.getForObject(URL + "/payment/zk", String.class);
	}

}
