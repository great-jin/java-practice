package com.kangxg.Main;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.kangxg.po.Person;
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        dfindPersonByIdTest();
    }

    public static void dfindPersonByIdTest() throws Exception{
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //加载关联的映射文件
        InputStream is =Resources.getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =sqlSessionFactory.openSession();

        Person person = sqlSession.selectOne("com.kangxg.mapper"+".PersonMapper.findPersonById",1 );
        System.out.println(person);
        //关闭SqlSession
        sqlSession.close();
    }
}
