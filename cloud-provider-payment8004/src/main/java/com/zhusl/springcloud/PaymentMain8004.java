package com.zhusl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 发现服务
public class PaymentMain8004 {
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8004.class, args);
	}
}
