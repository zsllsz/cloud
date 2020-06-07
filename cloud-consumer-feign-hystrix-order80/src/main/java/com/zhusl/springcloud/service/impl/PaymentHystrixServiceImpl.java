package com.zhusl.springcloud.service.impl;

import org.springframework.stereotype.Component;

import com.zhusl.springcloud.service.PaymentHystrixService;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService{

	@Override
	public String paymentOk(Integer id) {
		return "paymentOk-default-return";
	}

	@Override
	public String paymentError(Integer id) {
		return "paymentError-default-return";
	}

}
