package com.yang.springboot.configuration.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author admin 2022/3/25 11:02
 */
@Component
public class ESClientFactory {

    @Value("${es.cluster-name}")
    private String clusterName;

    //@PostConstruct
    public void init() {
        System.out.println("clusterName: " + clusterName);
        System.out.println("123");
    }

    public String getClustName() {
        return clusterName;
    }
}
