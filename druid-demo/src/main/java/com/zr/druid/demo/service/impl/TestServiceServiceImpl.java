package com.zr.druid.demo.service.impl;

import com.zr.druid.demo.mapper.TestMapper;
import com.zr.druid.demo.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zr
 * @ClassName: TestServiceServiceImpl
 * @Description: TODO
 * @date 2019/4/28 17:27
 */
@Service
public class TestServiceServiceImpl implements TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    public List<Map<String, Object>> queryAll() {
        return testMapper.queryAll();
    }
}
