package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service-url.nacos-user-service}")
	private String serverUrl;
	
	@GetMapping("/order/{id}")
	public String getPayment(@PathVariable("id") Integer id) {
		return restTemplate.getForObject(serverUrl + "/provider/payment/" + id, String.class);
	}
}
