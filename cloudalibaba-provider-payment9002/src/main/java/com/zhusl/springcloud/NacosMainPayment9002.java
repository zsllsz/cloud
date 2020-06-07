package com.zhusl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosMainPayment9002 {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(NacosMainPayment9002.class, args);
	}
}
