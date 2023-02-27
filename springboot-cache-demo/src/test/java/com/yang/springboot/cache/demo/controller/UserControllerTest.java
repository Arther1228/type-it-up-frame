package com.yang.springboot.cache.demo.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author yangliangchuang 2023/2/20 10:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext applicationContext;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
    }

    private void testCacheMethod() throws Exception {

        String json = "";
        //执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user/test_cache")
                        .content(json.getBytes()) //传json参数
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                //  .header("Authorization", "Bearer ********-****-****-****-************")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }

    /**
     * 如果使用redis缓存，需要增加实现对象的序列化，而且要将redis的依赖包去掉
     * @throws Exception
     */
    @Test
    public void testCache() throws Exception {

        for (int i = 0; i < 2 ; i++) {
            testCacheMethod();
        }
    }

    @Test
    public void testRedisCache() throws Exception {

        String json = "";
        //执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/user/test/redis")
                        .content(json.getBytes()) //传json参数
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                //  .header("Authorization", "Bearer ********-****-****-****-************")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }


}