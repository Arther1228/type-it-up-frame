/*
package com.yang.springboot.demo.configuration.propertySource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource(value = {"classpath:config.properties"},encoding="gbk")
public class GetProperties {

    @Value("${zhbin.config.web-configs.name}")
    private String name;
    @Value("${zhbin.config.web-configs.age}")
    private String age;

    public String getConfig() {
        return name + "-----" + age;
    }

    @PostConstruct
    public void init() {
        String config = name + "-----" + age;
        System.out.println(config);
    }
}


 */