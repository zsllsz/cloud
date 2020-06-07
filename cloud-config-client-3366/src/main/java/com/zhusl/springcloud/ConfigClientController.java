package com.zhusl.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigClientController {
	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/info")
	public String getInfo() {
		return configInfo;
	}
}
