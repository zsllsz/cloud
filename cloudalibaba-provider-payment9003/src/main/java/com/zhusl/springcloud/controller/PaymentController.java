package com.zhusl.springcloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhusl.springcloud.common.JsonResult;
import com.zhusl.springcloud.entities.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Value("${server.port}")
	private int port;
	
	public static Map<Long, Payment> map = new HashMap<>();
	// 偷懒，不去连数据库查记录了
	static {
		map.put(1L, new Payment(1L,"111"));
		map.put(1L, new Payment(2L,"222"));
		map.put(1L, new Payment(3L,"333"));
	}
	
	@GetMapping("/{id}")
	public JsonResult<?> payment(@PathVariable("id") Long id){
		return new JsonResult<>(200, "success from " + port, map.get(id));
	}
}
