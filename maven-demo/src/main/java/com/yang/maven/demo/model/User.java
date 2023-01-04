package com.yang.maven.demo.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author yangliangchuang 2022/11/11 14:26
 */
@Data
@Builder
public class User {
    private String userId;

    private String userName;
}
