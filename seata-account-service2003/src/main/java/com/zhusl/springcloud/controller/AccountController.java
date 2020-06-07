package com.zhusl.springcloud.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhusl.springcloud.domain.CommonResult;
import com.zhusl.springcloud.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/decrease")
	public CommonResult<?> decrease(Long userId, BigDecimal money) {
		accountService.decrease(userId, money);
		return new CommonResult<>(200, "扣减余额成功!", null);
	}

}
