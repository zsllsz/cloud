package com.zhusl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // 激活openfeign
public class OrderFeignMain80 {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderFeignMain80.class, args);
	}


}
