package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhusl.springcloud.common.JsonResult;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Value("${service-url.nacos-user-service}")
	private String url;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/fallback/{id}")
	@SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
	public JsonResult<?> fallback(@PathVariable("id") Long id){
		JsonResult<?> result = restTemplate.getForObject(url + "/payment/" + id, JsonResult.class);
		if (id == 4) {
			throw new IllegalArgumentException("非法参数");
		} else if (result.getData() == null) {
			throw new NullPointerException("没有该id对应的记录");
		}
		return result;
	}
	
	
	public JsonResult<?> handlerFallback(@PathVariable("id") Long id, Throwable e){
		return new JsonResult<>(444, "没有id" + id + "对应的记录，这是兜底方法，" + e.getMessage());
	}
	
	
	public JsonResult<?> blockHandler(@PathVariable("id") Long id, BlockException e){
		return new JsonResult<>(445, "id" + id + "的记录配置违规了，这是兜底方法，" + e.getMessage());
	}
	
}
