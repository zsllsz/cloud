package com.zhusl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhusl.springcloud.domain.CommonResult;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

	/** 扣减库存 */
	@PostMapping("/storage/decrease")
	public CommonResult<?> decrease(@RequestParam("productId") Long id, @RequestParam("count") Integer count);
}
