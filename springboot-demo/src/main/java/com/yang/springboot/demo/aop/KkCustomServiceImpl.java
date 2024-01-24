package com.yang.springboot.demo.aop;

import org.springframework.stereotype.Service;

/**
 * @author yangliangchuang 2024-01-24 8:46
 */

@Service("kkCustomService")
public class KkCustomServiceImpl implements KkCustomsService{

    @Override
    public void saveKkCustoms(String model, String method) {

        System.out.println("save kk-customs");

    }
}
