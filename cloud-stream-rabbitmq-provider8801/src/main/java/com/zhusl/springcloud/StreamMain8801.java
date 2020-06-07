package com.zhusl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamMain8801 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StreamMain8801.class, args);
	}

}
