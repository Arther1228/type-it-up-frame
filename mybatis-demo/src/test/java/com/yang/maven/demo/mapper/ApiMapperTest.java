package com.yang.maven.demo.mapper;

import com.yang.mybatis.demo.entity.ParamMap;
import com.yang.mybatis.demo.mapper.ApiMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;


/**
 * @author yangliangchuang 2023/3/2 15:09
 * @参考：light-api
 * @备注：因为没有使用Spring整合，所以需要手动增加Mapper: <mapper class="com.yang.mybatis.demo.mapper.ApiMapper"/>
 */
public class ApiMapperTest {

    private SqlSessionFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));

    }

    @Test
    public void selectOneTest() {
        ParamMap param = new ParamMap();
        String sql = "SELECT id,name,age FROM student WHERE id = #{id}";
        param.setSqlStatement(sql);
        param.put("id", 1);

        SqlSession sqlSession = factory.openSession(true); // 自动提交事务
        ApiMapper apiMapper = sqlSession.getMapper(ApiMapper.class);

        LinkedHashMap<String, Object> stringObjectLinkedHashMap = apiMapper.selectOne(param);
        System.out.println(stringObjectLinkedHashMap.size());
    }

    @Test
    public void selectListTest() {
        ParamMap param = new ParamMap();
        String sql = "select * from author where 1 = 1";
        param.setSqlStatement(sql);

        SqlSession sqlSession = factory.openSession(true); // 自动提交事务
        ApiMapper apiMapper = sqlSession.getMapper(ApiMapper.class);

        List<LinkedHashMap<String, Object>> linkedHashMapList = apiMapper.selectList(param);
        System.out.println(linkedHashMapList.size());
    }

}