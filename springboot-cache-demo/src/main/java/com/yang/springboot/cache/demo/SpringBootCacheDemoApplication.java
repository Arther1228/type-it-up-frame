package com.yang.springboot.cache.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author admin
 */
@EnableCaching
@SpringBootApplication
public class SpringBootCacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheDemoApplication.class, args);
    }

}
