package com.yang.springboot.cache.demo.controller;

import com.yang.springboot.cache.demo.model.TaskInfoDTO;
import com.yang.springboot.cache.demo.service.TaskInfoService;
import com.yang.springboot.cache.demo.util.IResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private TaskInfoService testBuzz;

    @GetMapping("/test_cache")
    public IResp<TaskInfoDTO> testCache() {
        TaskInfoDTO taskInfoDTO = this.testBuzz.getTask("task123");
        return IResp.getSuccessResult(taskInfoDTO);
    }

    @RequestMapping("/test/redis")
    @Cacheable({"hot"})
    public int test() {
        return 222;
    }

}