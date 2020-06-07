package com.zhusl.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.zhusl.springcloud.dao"})
public class MybatisConfig {
}
