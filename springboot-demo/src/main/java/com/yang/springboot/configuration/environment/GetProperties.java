/*
package com.yang.springboot.configuration.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource(value = {"classpath:config.properties"}, encoding = "gbk")
public class GetProperties {

    @Autowired
    Environment environment;

    @PostConstruct
    public String getEnvConfig() {
        String name = environment.getProperty("zhbin.config.web-configs.name");
        String age = environment.getProperty("zhbin.config.web-configs.age");
        return name + "-----" + age;
    }
}


 */