package com.yang.springboot.demo.configuration.configurationProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConfigurationProperties(prefix = "zhbin.config")
@Data
public class StudentYml {
    
    // webConfigs务必与配置文件相对应，写为驼峰命名方式
    private WebConfigs webConfigs = new WebConfigs();

    @Data
    public static class WebConfigs {
        private String name;
        private String age;
    }

    //@PostConstruct
    public void init(){
        WebConfigs webConfigs = new WebConfigs();
        String config = webConfigs.getAge() + "-----" + webConfigs.getName();
        System.out.println(config);
    }

}