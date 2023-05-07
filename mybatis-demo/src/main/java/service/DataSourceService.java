package service;

import mapper.ApiMapper;

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