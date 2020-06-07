package com.zhusl.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class PaymentController {
	
	@GetMapping("/payment/{id}")
	public String payment(@PathVariable("id") Integer id) {
		return "success 9002";
	}
}
