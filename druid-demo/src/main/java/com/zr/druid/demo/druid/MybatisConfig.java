package com.zr.druid.demo.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MybatisConfig {

    @Autowired
    DruidBean druidProperties;

    /**
     * 数据源
     */
    private DruidDataSource dataSourceStrom() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }


    /**
     * 单数据源连接池配置
     */
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource() {
        return dataSourceStrom();
    }
}