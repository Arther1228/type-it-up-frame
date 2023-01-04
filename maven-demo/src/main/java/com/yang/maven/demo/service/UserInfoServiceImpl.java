package com.yang.maven.demo.service;

import com.yang.maven.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangliangchuang 2022/11/11 14:29
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Override
    public List<User> getUserInfoList(){

        List<User> userList = new ArrayList<>();

        userList.add(User.builder().userId("1").userName("张三").build());
        userList.add(User.builder().userId("2").userName("李四").build());

        return userList;
    }

}
