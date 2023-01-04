/*
package com.yang.springboot.configuration.configurationProperties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "zhbin.config")
@Data
public class StudentYmlList {
    
    // webConfigs务必与配置文件相对应，写为驼峰命名方式
    private List<WebConfigs> webConfigs = new ArrayList<>();

    @Data
    public static class WebConfigs {
        private String name;
        private String age;
    }

    @PostConstruct
    public void init(){
        WebConfigs webConfigs = new WebConfigs();
        String config = webConfigs.getAge() + "-----" + webConfigs.getName();
        System.out.println(config);
    }

}

*/