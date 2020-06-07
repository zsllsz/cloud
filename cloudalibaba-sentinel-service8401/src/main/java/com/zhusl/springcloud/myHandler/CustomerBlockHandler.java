package com.zhusl.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhusl.springcloud.common.JsonResult;
import com.zhusl.springcloud.entities.Payment;

public class CustomerBlockHandler {
	
	public static JsonResult<?> handlerException1(BlockException e){
		return new JsonResult<Payment>(444, "自定义返回信息1");
	}
	
	public static JsonResult<?> handlerException2(BlockException e){
		return new JsonResult<Payment>(444, "自定义返回信息2");
	}
}
