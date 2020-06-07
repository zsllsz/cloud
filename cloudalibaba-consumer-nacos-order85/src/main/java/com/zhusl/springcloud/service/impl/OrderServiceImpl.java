package com.zhusl.springcloud.service.impl;

import org.springframework.stereotype.Component;

import com.zhusl.springcloud.common.JsonResult;
import com.zhusl.springcloud.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService{

	@Override
	public JsonResult<?> payment(Long id) {
		return new JsonResult<>(446, "这是兜底的方法");
	}
}
