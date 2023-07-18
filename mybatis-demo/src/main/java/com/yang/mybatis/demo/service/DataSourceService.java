package com.yang.mybatis.demo.service;


import com.yang.mybatis.demo.mapper.ApiMapper;

/**
 * @author wangxiaoyang
 */
public interface DataSourceService {

    /**
     * 获取ApiMapper
     *
     * @param dataSourceConfigId 数据源配置ID
     * @return ApiMapper
     */
    ApiMapper getApiMapper(Integer dataSourceConfigId);

}