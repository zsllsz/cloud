package com.zhusl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigMain3344 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConfigMain3344.class, args);
	}

}
