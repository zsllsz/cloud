package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhusl.springcloud.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/ok/{id}")
	public String paymentOk(@PathVariable("id") Integer id) {
		return paymentService.paymentOk(id) + "\r\n" + port;
	}
	
	@GetMapping("/error/{id}")
	public String paymentError(@PathVariable("id") Integer id) {
		return paymentService.paymentError(id) + "\r\n" + port;
	}
	
	//=================== 服务熔断 ===========
	@GetMapping("/breaker/{id}")
	public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
		return paymentService.paymentCircuitBreaker(id);
	}
}
