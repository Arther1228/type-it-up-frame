package com.yang.springboot.demo.controller;

import com.yang.springboot.demo.configuration.value.ESClientFactory;
import com.yang.springboot.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author admin
 */
@RestController
@RequestMapping("user2")
public class UserController2 {

    @Autowired
    private ESClientFactory esClientFactory;

    @PostMapping("/addUser")
    public User addUser(@RequestBody @Valid User user) {
        System.out.println("request accept.");
        System.out.println(esClientFactory.getClustName());
        return user;
    }
}