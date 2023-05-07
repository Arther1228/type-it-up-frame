package mapper;

import entity.ParamMap;
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
 * @参考：light-api，未完成
 */
public class ApiMapperTest {

    private SqlSessionFactory factory;

    private static String sql = "SELECT id,name,age FROM student WHERE id = #{id}";

    @Before
    public void setUp() throws Exception {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));

    }

    @Test
    public void selectList() {
        ParamMap param = new ParamMap();
        param.setSqlStatement(sql);
        param.put("id", 1);

        SqlSession sqlSession1 = factory.openSession(true); // 自动提交事务
        ApiMapper apiMapper = sqlSession1.getMapper(ApiMapper.class);

        List<LinkedHashMap<String, Object>> selectList = apiMapper.selectList(param);
        System.out.println(selectList.size());
    }
}