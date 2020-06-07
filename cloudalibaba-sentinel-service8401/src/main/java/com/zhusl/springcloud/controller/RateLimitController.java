package com.zhusl.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhusl.springcloud.common.JsonResult;
import com.zhusl.springcloud.entities.Payment;
import com.zhusl.springcloud.myHandler.CustomerBlockHandler;

@RestController
@RequestMapping("/ratelimit")
public class RateLimitController {

	@GetMapping("/bySource")
	@SentinelResource(value = "bySource", blockHandler = "handleException")
	public JsonResult<?> bySource() {
		return new JsonResult<Payment>(200, "按资源名称限流测试通过", new Payment(1L, "6666"));
	}
	
	public JsonResult<?> handleException(BlockException e){
		return new JsonResult<>(400, e.getClass().getCanonicalName() + "\t服务不可用");
	}
	
	@GetMapping("/byUrl")
	@SentinelResource(value = "byUrl")
	public JsonResult<?> byUrl(){
		return new JsonResult<Payment>(200, "按url限流测试通过", new Payment(1L, "6666"));
	}
	
	@GetMapping("/customerBlockHandler")
	@SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException1")
	public JsonResult<?> customerBlockHandler(){
		return new JsonResult<Payment>(200, "自定义限流处理测试通过", new Payment(1L, "6666"));
	}
}
