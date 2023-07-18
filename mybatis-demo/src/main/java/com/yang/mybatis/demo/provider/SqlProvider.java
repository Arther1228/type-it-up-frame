package com.yang.mybatis.demo.provider;


import com.yang.mybatis.demo.entity.ParamMap;

/**
 * @author wangxiaoyang
 */
public class SqlProvider {

    public String provideSql(ParamMap param) {
        return "<script>" + param.getSqlStatement() + "</script>";
    }

}