package com.zhusl.springcloud.loadBalance;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;

/**
 * 手写Ribbon负载均衡算法
 * @author zhu
 *
 */
public interface LoadBalancer {
	/**
	 * 获取eureka中所有的服务
	 * @param serviceInstances
	 * @return
	 */
	ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
