package com.yang.springboot.starter.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// EnableConfigurationProperties value数组中的配置类起作用
@EnableConfigurationProperties(value = {MyStarterProperties.class})
public class MyStarterAutoConfiguration {

    @Autowired
    private MyStarterProperties myStarterProperties;

    @Bean
    @ConditionalOnMissingBean(MyStarterConfig.class)
    public MyStarterConfig myStarterConfig(){
        return new MyStarterConfig(myStarterProperties);
    }

}