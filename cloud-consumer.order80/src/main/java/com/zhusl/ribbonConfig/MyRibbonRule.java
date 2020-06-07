package com.zhusl.ribbonConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MyRibbonRule {

	@Bean
	public IRule randRule() {
		return new RandomRule();
	}
}
