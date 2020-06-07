package com.zhusl.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhusl.springcloud.dao.OrderDao;
import com.zhusl.springcloud.domain.Order;
import com.zhusl.springcloud.service.AccountService;
import com.zhusl.springcloud.service.OrderService;
import com.zhusl.springcloud.service.StorageService;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private StorageService storageService;
	@Autowired
	private AccountService accountService;

	@Override
	@GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
	public void create(Order order) {
		log.info("================= 新建订单start ==============");
		orderDao.create(order);
		log.info("================= 新建订单end ==============");
		
		log.info("================= 订单微服务调用库存微服务扣减库存start ==============");
		storageService.decrease(order.getProductId(), order.getCount());
		log.info("================= 订单微服务调用库存微服务扣减库存end ==============");
		
		log.info("================= 订单微服务调用账户微服务做扣减余额start ==============");
		accountService.decrease(order.getUserId(), order.getMoney());
		log.info("================= 订单微服务调用账户微服务做扣减余额end ==============");
		
		log.info("================= 修改订单状态start ==============");
		orderDao.update(order.getUserId(), 0);
		log.info("================= 修改订单状态end ==============");
		
		log.info("================= 下单完成✔ ==============");
		
	}

}
