package com.zhusl.springcloud.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	private Long id;
	
	/** 用户id */
	private Long userId;
	/** 总额度 */
	private BigDecimal total;
	/** 已用额度 */
	private BigDecimal used;
	/** 剩余额度 */
	private BigDecimal residue;

}
