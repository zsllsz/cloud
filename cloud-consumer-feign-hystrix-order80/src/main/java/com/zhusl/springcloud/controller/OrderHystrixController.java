package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhusl.springcloud.service.PaymentHystrixService;

@RestController
@RequestMapping("/order")
/*@DefaultProperties(defaultFallback = "defaultMethod", commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
})*/
public class OrderHystrixController {

	@Autowired
	private PaymentHystrixService phService;
	
	@GetMapping("/hystrix/ok/{id}")
	/*@HystrixCommand*/
	public String paymentOk(@PathVariable("id") Integer id) {
		return phService.paymentOk(id);
	}
	
	@GetMapping("/hystrix/error/{id}")
	/*@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
	})*/
	public String paymentError(@PathVariable("id") Integer id) {
		return phService.paymentError(id);
	}
	
	/*public String paymentError_default(@PathVariable("id")Integer id) {
		return "这是消费端兜底的方法";
	}
	
	public String defaultMethod() {
		return "我是全局默认的服务降级配置";
	}*/
}
