package com.zhusl.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhusl.springcloud.dao.StorageDao;
import com.zhusl.springcloud.service.StorageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
	
	@Autowired
	private StorageDao storageDao;

	@Override
	public void decrease(Long productId, Integer count) {
		log.info("============== storageService 扣减库存 start =============");
		storageDao.decrease(productId, count);
		log.info("============== storageService 扣减库存 end =============");
	}
}
