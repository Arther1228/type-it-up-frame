/*
package service.impl;

import cn.linter.light.entity.JobJdbcDataSource;
import cn.linter.light.exception.BusinessException;
import cn.linter.light.mapper.ApiMapper;
import cn.linter.light.service.JobJdbcDataSourceService;
import cn.linter.light.util.JSONUtils;
import cn.linter.light.wrapper.ResultMapWrapperFactory;
import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import service.DataSourceService;

import java.util.Map;

*/
/**
 * @author wangxiaoyang
 *//*

@Slf4j
public class DataSourceServiceImpl implements DataSourceService {

    private final JobJdbcDataSourceService jobJdbcDataSourceService;

    public DataSourceServiceImpl(JobJdbcDataSourceService jobJdbcDataSourceService) {
        this.jobJdbcDataSourceService = jobJdbcDataSourceService;
    }

    @Override
    public ApiMapper getApiMapper(Integer dataSourceConfigId) {
        JobJdbcDataSource jobJdbcDataSource = jobJdbcDataSourceService.getById(dataSourceConfigId);
        //TODO 解析出参数
        String connectionParams = jobJdbcDataSource.getConnectionParams();
        Map<String, String> stringStringMap = JSONUtils.toMap(connectionParams);
        String jdbcUrl = stringStringMap.get("jdbcUrl") ;
        String userName = stringStringMap.get("username");
        String password = stringStringMap.get("password");
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(jdbcUrl);
        hikariDataSource.setUsername(userName);
        hikariDataSource.setPassword(password);
        Configuration configuration = new Configuration();
        configuration.addMapper(ApiMapper.class);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addInterceptor(new PageInterceptor());
        configuration.setObjectWrapperFactory(new ResultMapWrapperFactory());
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(hikariDataSource);
        sqlSessionFactoryBean.setConfiguration(configuration);
        SqlSessionFactory sqlSessionFactory;
        try {
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            log.error("获取SqlSessionFactory失败", e);
            throw new BusinessException("获取SqlSessionFactory失败", e);
        }
        MapperFactoryBean<ApiMapper> mapperFactoryBean = new MapperFactoryBean<>();
        mapperFactoryBean.setMapperInterface(ApiMapper.class);
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
        ApiMapper apiMapper;
        try {
            apiMapper = mapperFactoryBean.getObject();
        } catch (Exception e) {
            log.error("获取MapperFactoryBean失败", e);
            throw new BusinessException("获取MapperFactoryBean失败", e);
        }
        return apiMapper;
    }

}*/
