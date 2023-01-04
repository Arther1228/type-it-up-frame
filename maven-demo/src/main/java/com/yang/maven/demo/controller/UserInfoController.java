package com.yang.maven.demo.controller;

import com.yang.maven.demo.model.User;
import com.yang.maven.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangliangchuang 2022/11/11 14:27
 */
@RestController
@RequestMapping("/v1")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getUserList")
    public List<User> addUser() {
        List<User> userInfoList = userInfoService.getUserInfoList();
        return userInfoList;
    }

}
