package com.zhusl.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhusl.springcloud.common.JsonResult;
import com.zhusl.springcloud.entities.Payment;
import com.zhusl.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/create")
	public JsonResult<Payment> create(@RequestBody Payment payment){
		int result = paymentService.create(payment);
		log.info("======== " + serverPort + "插入结果：" + result);
		if (result > 0) {
			return new JsonResult<Payment>(200, "success", null);
		} else {
			return new JsonResult<Payment>(400, "fail", null);
		}
		
	}
	
	@GetMapping("/{id}")
	public JsonResult<Payment> getPaymentById(@PathVariable("id") Long id){
		Payment payment = paymentService.getPaymentById(id);
		try {TimeUnit.SECONDS.sleep(3);} catch (Exception e) {e.printStackTrace();}
		log.info("======== " + serverPort + "执行操作");
		if (payment != null) {
			return new JsonResult<Payment>(200, "success，port：" + serverPort, payment);
		} else {
			return new JsonResult<Payment>(400, "fail", null);
		}
	}

}
