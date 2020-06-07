package com.zhusl.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class PaymentService {

	public String paymentOk(Integer id) {
		/*try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return " thats ok";
	}
	
	@HystrixCommand(fallbackMethod = "paymentError_default", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
	})
	public String paymentError(Integer id) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "somethind wrong";
	}
	
	public String paymentError_default(Integer id) {
		return "这是兜底的方法";
	}
	
	
	//==================== 服务熔断 ===================\\
	@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率达到多少后跳闸
			// 10次请求有6次是失败的，就进行服务熔断，10秒后会变为half open状态，看看能否请求成功，如果成功就变成close状态
	})
	public String paymentCircuitBreaker(Integer id) {
		if (id < 0) {
			throw new RuntimeException("id不能为负数");
		}
		return "调用成功";
	}
	
	public String paymentCircuitBreaker_fallback(Integer id) {
		return "id不能为负数";
	}
}
