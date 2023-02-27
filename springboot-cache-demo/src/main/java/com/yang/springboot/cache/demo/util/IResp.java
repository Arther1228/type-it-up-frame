package com.yang.springboot.cache.demo.util;

import com.yang.springboot.cache.demo.model.TaskInfoDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yangliangchuang 2023/2/20 10:11
 */

@Data
public class IResp <T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private  T successResult;

    public IResp(T data) {
        super();
        successResult = data;
    }


    public static IResp<TaskInfoDTO> getSuccessResult(TaskInfoDTO taskInfoDTO) {
        return  new IResp<>(taskInfoDTO);
    }
}