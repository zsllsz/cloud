package com.zhusl.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhusl.springcloud.domain.Order;

@Mapper
public interface OrderDao {
	
	/** 创建订单 */
	public void create(Order order);
	
	/** 修改订单状态 */
	public void update(@Param("userId") Long userId, @Param("status") Integer status);

}
