package com.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    private static final Logger LOG=LoggerFactory.getLogger(MybatisPlusConfig.class);
    /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        LOG.info("==========加载了Spring-plus分页插件==========");
        PaginationInterceptor page = new PaginationInterceptor();
        return page;
    }

}
