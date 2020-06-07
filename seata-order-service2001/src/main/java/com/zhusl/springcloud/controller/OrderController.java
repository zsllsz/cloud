package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhusl.springcloud.domain.CommonResult;
import com.zhusl.springcloud.domain.Order;
import com.zhusl.springcloud.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/create")
	public CommonResult<?> create(Order order) {
		orderService.create(order);
		return new CommonResult<>(200, "订单创建成功", null);
	}

}
