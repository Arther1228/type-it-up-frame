/*
package com.yang.springboot.configuration.propertySource;

import com.yang.springboot.configuration.propertySource.YmlConfigFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource(value = {"classpath:vehicle.yaml"}, encoding = "gbk", factory = YmlConfigFactory.class)
public class GetYamlProperties {

    @Value("${PlateClass.ptype}")
    private String name;
    @Value("${PlateNumberClass}")
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