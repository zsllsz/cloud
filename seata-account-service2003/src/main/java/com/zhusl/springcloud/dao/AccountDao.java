package com.zhusl.springcloud.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {
	/** 扣减余额 */
	void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
