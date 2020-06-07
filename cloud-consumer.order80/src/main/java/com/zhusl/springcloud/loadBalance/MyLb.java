package com.zhusl.springcloud.loadBalance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * 手写Ribbon负载均衡算法的实现类
 * @author zhu
 *
 */
@Component
public class MyLb implements LoadBalancer{
	
	private AtomicInteger ainteger = new AtomicInteger(0);
	
	private final int getAndIncrement() {
		int current;
		int next;
		// 这里用到的是自旋锁，CAS
		do {
			current = this.ainteger.get();
			next = current >= Integer.MAX_VALUE ? 0 : (current + 1);
		} while(!this.ainteger.compareAndSet(current, next));
		System.out.println("next的值===========" + next);
		return next;
	}

	@Override
	public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
		int index = getAndIncrement() % serviceInstances.size();
		return serviceInstances.get(index);
	}

}
