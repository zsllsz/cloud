package com.zhusl.springcloud.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class DashBoardConfig {

	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getBean() {
		HystrixMetricsStreamServlet bean = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> register = new ServletRegistrationBean<HystrixMetricsStreamServlet>(bean);
		register.setLoadOnStartup(1);
		register.addUrlMappings("/hystrix.stream");
		register.setName("HystrixMetricsStreamServlet");
		return register;
	}
}
