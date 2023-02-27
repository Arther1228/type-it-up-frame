package com.yang.springboot.cache.demo.service;

import com.yang.springboot.cache.demo.model.TaskInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author yangliangchuang 2023/2/20 10:09
 */
@Slf4j
@Service
public class TaskInfoService {

    @Cacheable(cacheNames = {"task"})
    public TaskInfoDTO getTask(String taskId) {
        log.info("TestBuzz.getTask mock query from DB......");
        TaskInfoDTO taskInfoDTO = new TaskInfoDTO();
        taskInfoDTO.setTaskId(taskId);
        taskInfoDTO.setApplicantId("system");
        taskInfoDTO.setDescription("test");
        return taskInfoDTO;
    }


}
