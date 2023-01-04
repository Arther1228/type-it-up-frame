package com.yang.springdatajpademo.controller;

import com.yang.springdatajpademo.model.DevUser;
import com.yang.springdatajpademo.repository.base.BaseRepositoryImpl;
import com.yang.springdatajpademo.util.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private BaseRepositoryImpl baseRepository;

    @GetMapping("/cs/save")
    public Boolean csSave() {
        DevUser devUser = new DevUser();
        devUser.setUsername("xxasdasdasdasdasdasdasd");
        devUser.setPassword("dddfadadadasdasd");
        return baseRepository.save(devUser);
    }

    @GetMapping("/cs/findById")
    public @ResponseBody DevUser csF() {
        DevUser devUser = (DevUser) baseRepository.findByid(DevUser.class, 1);
        return devUser;
    }

    @GetMapping("/cs/delbyid")
    public Boolean csDelById() {
        return baseRepository.deleteById(DevUser.class, 5);
    }

    @GetMapping("/cs/findByField")
    public List<DevUser> csFindByField() {
        return baseRepository.findByField(DevUser.class, "username", "1");
    }

    @GetMapping("/cs/delByIds")
    public boolean csdelByIds() {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        return baseRepository.deleteByIds(DevUser.class, list);
    }

    @GetMapping("/cs/findByFields")
    public List<DevUser> csFindByFields() {
        LinkedHashMap map = new LinkedHashMap();
        map.put("username", "12");
        map.put("password", "dddf");
        return baseRepository.findByMoreFiled(DevUser.class, map);
    }

    @GetMapping("/cs/del")
    public Boolean csDel() {
        DevUser devUser = new DevUser();
        devUser.setId(6);
        return baseRepository.delete(devUser);
    }

    @GetMapping("/cs/upd")
    public Boolean csUpd() {
        DevUser devUser = new DevUser();
        devUser.setId(3);
        devUser.setUsername("123345567qweqwwwqe");
        devUser.setPassword("asdaslkdaksdfviosdhfgsdbfkjhdasiofhasdfbdasihgo");
        return baseRepository.update(devUser, devUser.getId());
    }

    @GetMapping("/cs/getCount")
    public Integer csgetCount() {
        LinkedHashMap map = new LinkedHashMap();
        map.put("username", "1");
        return baseRepository.findCount(DevUser.class, map);
    }

    @GetMapping("/cs/findByParm")
    public List<DevUser> csfindByParm() {
        Params build = Params.builder().Euqal("password", "wqeq").Like("username", "%q%").OrderBy("id", "desc").build();
        return baseRepository.findByParams(DevUser.class, build);
    }
}
