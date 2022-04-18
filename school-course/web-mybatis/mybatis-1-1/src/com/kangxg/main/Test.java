package com.kangxg.main;

import com.kangxg.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {

    public static void main(String[] args) throws Exception {
        findUserTest();
    }

    public static void findUserTest()throws Exception{
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //加载关联的映射文件
        InputStream is = Resources.getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("com.kangxg.mapper"+".UserMapper.findUserWithOrders",1 );
        System.out.println(user);
        sqlSession.close();
    }

}
