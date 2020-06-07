package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhusl.springcloud.domain.CommonResult;
import com.zhusl.springcloud.service.StorageService;

@RestController
@RequestMapping("/storage")
public class StorageController {

	@Autowired
	private StorageService storageService;
	
	@PostMapping("/decrease")
	public CommonResult<?> decrease(Long productId, Integer count) {
		storageService.decrease(productId, count);
		return new CommonResult<>(200, "扣减库存成功！", null);
	}
}
