package com.yang.springdatajpademo;

import com.yang.springdatajpademo.model.DevUser;
import com.yang.springdatajpademo.repository.base.BaseRepository;
import com.yang.springdatajpademo.util.Params;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class SpringDataJpaDemoApplicationTests {

    @Autowired
    private BaseRepository baseRepository;

    @Test
    public void saveTest(){
        Boolean save = baseRepository.save(DevUser.builder().id(7).username("a").password("a").addtime(new Date()).build());
        System.out.println(save);
    }

    @Test
    public void saveAllTest(){
        List<DevUser> devUserList = new ArrayList<>();
        devUserList.add(DevUser.builder().id(5).username("a").password("a").addtime(new Date()).build());
        devUserList.add(DevUser.builder().id(6).username("a").password("a").addtime(new Date()).build());
        baseRepository.saveAll(devUserList);
        System.out.println("123");
    }

    @Test
    public void findMaxTime(){
        Timestamp addtime = baseRepository.findMaxTime(DevUser.class, "addtime");
        System.out.println(addtime);
    }

    @Test
    public void selectPageTest() {
        Params params = Params.builder().Limit(1, 1).build();
        List<DevUser> devUserList = baseRepository.findByParams(DevUser.class, params);
        int size = devUserList.size();
        System.out.println(size);
    }

    @Test
    public void findByIdTest() {
        DevUser devUser = new DevUser();
        devUser.setId(1);
        devUser.setUsername("x");
        devUser.setPassword("x");

        Object byid = baseRepository.findByid(DevUser.class, devUser.getId());
        System.out.println(byid);

        assertNotNull(baseRepository.findByid(DevUser.class, devUser.getId()));
    }


}
