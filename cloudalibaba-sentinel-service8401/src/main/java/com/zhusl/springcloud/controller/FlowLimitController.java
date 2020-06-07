package com.zhusl.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

@RestController
@RequestMapping("/sentinel")
public class FlowLimitController {

	@GetMapping("/testA")
	public String testA() {
		return "=========== testA ==========";
	}
	
	@GetMapping("/testB")
	public String testB() {
		return "=========== testB ==========";
	}
	
	@GetMapping("/testC")
	public String testC() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "=========== test RT ==========";
	}
	
	@GetMapping("/testD")
	public String testD() {
		//int x = 10 / 0;
		return "============ test 异常比例 ============";
	}
	
	@GetMapping("/testHotKey")
	@SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey") // 这个value值随意，只要唯一即可，但是一般和@GetMapping中的一致
	public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
			                 @RequestParam(value = "p2", required = false) String p2) {
		return "test hot key";
	}
	
	/**
	 * 兜底方法，参数除了原方法的参数，还要加上BlockException
	 * @param p1
	 * @param p2
	 * @param e
	 * @return
	 */
	public String deal_testHotKey(String p1, String p2, BlockException e) {
		return "兜底方法";
	}
}
