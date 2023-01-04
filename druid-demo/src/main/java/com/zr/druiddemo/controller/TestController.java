package com.zr.druiddemo.controller;

import com.zr.druiddemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author zr
 * @ClassName: UserController
 * @Description: TODO
 * @date 2019/4/28 17:21
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("index")
    @ResponseBody
    public List<Map<String, Object>> queryAll(){
        return testService.queryAll();
    }
}
