package com.yang.java.web.demo;

import com.alibaba.fastjson.JSONObject;
import com.yang.java.web.demo.configuration.GetResourceFileServlet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author yangliangchuang 2022/11/21 14:28
 */

public class GetResourceFileServletTest {

    GetResourceFileServlet getResourceFileServlet = null;

    @Before
    public void setUp() {
        getResourceFileServlet = new GetResourceFileServlet();

    }

    @Test
    public void testGetConfigration() throws ServletException, IOException, InterruptedException {
        JSONObject p = new JSONObject();
        p.put("demoRequest", "herbert 通过spring-test 测试servlet");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setContent(p.toString().getBytes());
        MockHttpServletResponse response = new MockHttpServletResponse();
        getResourceFileServlet.doPost(request, response);
        System.out.println(123);

    }
}
