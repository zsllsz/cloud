package com.zhusl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 表明这个项目是eureka注册中心
public class EurekaMain7002 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMain7002.class, args);

	}

}
