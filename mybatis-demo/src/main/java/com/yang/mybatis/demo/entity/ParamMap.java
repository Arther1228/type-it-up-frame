package com.yang.mybatis.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

/**
 * @author wangxiaoyang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ParamMap extends HashMap<String, Object> {
    private String sqlStatement;
}