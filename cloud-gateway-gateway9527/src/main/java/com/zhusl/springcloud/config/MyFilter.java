package com.zhusl.springcloud.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyFilter implements GlobalFilter, Ordered{

	/**
	 * 表示这个过滤器的优先级，数字越小优先级越高
	 */
	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("=================进去自定义全局过滤器=============");
		// 获取id参数
		String id = exchange.getRequest().getQueryParams().getFirst("id");
		if (!"1".equals(id)) {
			log.error("================= id不存在==================");
			// 设置返回码
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

}
