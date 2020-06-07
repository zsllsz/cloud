package com.zhusl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zhusl.springcloud.service.impl.PaymentHystrixServiceImpl;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {
	
	@GetMapping("payment/ok/{id}")
	public String paymentOk(@PathVariable("id") Integer id);
	
	@GetMapping("payment/error/{id}")
	public String paymentError(@PathVariable("id") Integer id);
}
