package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Value("${server.port}")
	private String port;

	@GetMapping("/consul")
	public String paymentzk() {
		return "该服务端口号为：" + port;
	}
}
