package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhusl.springcloud.common.JsonResult;
import com.zhusl.springcloud.entities.Payment;
import com.zhusl.springcloud.service.PaymentFeignService;

@RestController
@RequestMapping("/order")
public class OrderFeignController {

	@Autowired
	private PaymentFeignService pfService;
	
	@GetMapping("/{id}")
	public JsonResult<Payment> getPaymentById(@PathVariable("id") Long id){
		return pfService.getPaymentById(id);
	}
	
}
