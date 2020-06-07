package com.zhusl.springcloud.service.impl;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhusl.springcloud.dao.AccountDao;
import com.zhusl.springcloud.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void decrease(Long userId, BigDecimal money) {
		log.info("================ account-service 扣减余额 start ===============");
		try {
			TimeUnit.SECONDS.sleep(11);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		accountDao.decrease(userId, money);
		log.info("================ account-service 扣减余额 end ===============");
	}
}
