package com.zr.druid.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * @author yangliangchuang 2023/1/10 17:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {

    @Resource
    private TestService testService;

    @Test
    public void queryAll() {

        List<Map<String, Object>> maps = testService.queryAll();
        System.out.println(maps.size());

    }
}