package com.yang.spring.demo.aop;

import com.yang.spring.demo.SpringBootDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author yangliangchuang 2024-01-24 8:49
 */
@SpringBootTest(classes = SpringBootDemoApplication.class)
@RunWith(SpringRunner.class)
public class KkCustomsServiceTest {

    @Autowired
    private KkCustomsService kkCustomsService;

    @Autowired
    private QueryBaseInfoService queryBaseInfoService;

    @Test
    public void saveKkCustoms() {

        String model = "model";
        kkCustomsService.saveKkCustoms(model, "test");
    }

    @Test
    public void queryBaseInfoTest() {

        // 获取当前方法的名称
        queryBaseInfoService.saveKkCustoms();

    }
}
