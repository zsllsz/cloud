package com.zhusl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zhusl.springcloud.common.JsonResult;
import com.zhusl.springcloud.entities.Payment;

/**
 * 去调用服务端的controller，即8001的controller
 * @author zhu
 *
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") // 8001的微服务名称
public interface PaymentFeignService {
	/**
	 * 这个方法去调用8001的controller，
	 * 路由就是8001的controller中对应方法的路由
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/payment/{id}")
	JsonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
