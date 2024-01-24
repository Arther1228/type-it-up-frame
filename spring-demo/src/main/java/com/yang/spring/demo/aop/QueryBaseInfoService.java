package com.yang.spring.demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangliangchuang 2024-01-24 9:04
 */

@Service
public class QueryBaseInfoService {

    @Autowired
    private KkCustomsService kkCustomsService;

    public void saveKkCustoms(){
        String model = "model";
        String method = "QueryBaseInfoService";
        kkCustomsService.saveKkCustoms(model, method);
    }
}
