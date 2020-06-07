package com.zhusl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardMain9001 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HystrixDashBoardMain9001.class, args);
	}

}
