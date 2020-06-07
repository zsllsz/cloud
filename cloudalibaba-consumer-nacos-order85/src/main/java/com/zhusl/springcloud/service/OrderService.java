package com.zhusl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zhusl.springcloud.common.JsonResult;
import com.zhusl.springcloud.service.impl.OrderServiceImpl;

@FeignClient(value = "nacos-payment-provider", fallback = OrderServiceImpl.class)
public interface OrderService {

	@GetMapping("/payment/{id}")
	public JsonResult<?> payment(@PathVariable("id") Long id);
}
