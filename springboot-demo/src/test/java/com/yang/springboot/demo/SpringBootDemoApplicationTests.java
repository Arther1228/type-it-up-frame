package com.yang.springboot.demo;

import com.yang.springboot.starter.demo.config.MyStarterConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Autowired
    private MyStarterConfig myStarterConfig;

    @Test
    public void testMyStarter(){
        String name = myStarterConfig.getName();
        System.out.println(name);
    }

}
