package com.zhusl.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		RouteLocatorBuilder.Builder routes = builder.routes();
		// 意思就是访问localhost:9527/domestic将会转发到https://tuijian.hao123.com/domestic中去
		routes.route("path_id", r -> r.path("/domestic").uri("https://tuijian.hao123.com/domestic")).build();
		return routes.build();
	}
}
