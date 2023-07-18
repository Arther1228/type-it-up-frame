package com.yang.maven.demo.mapper;

import com.yang.mybatis.demo.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class BlogTest {

    private SqlSessionFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));

    }

    @Test
    public void testRestultMap() {
        SqlSession sqlSession = factory.openSession(true); // 自动提交事务
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        System.out.println(blogMapper.selectBlogDetails(1));

        sqlSession.close();
    }

}