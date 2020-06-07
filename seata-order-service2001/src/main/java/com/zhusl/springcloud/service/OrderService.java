package com.zhusl.springcloud.service;


import com.zhusl.springcloud.domain.Order;

public interface OrderService {
	
	/** 创建订单 */
	public void create(Order order);

}
