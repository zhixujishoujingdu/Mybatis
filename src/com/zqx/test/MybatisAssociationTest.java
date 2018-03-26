package com.zqx.test;

import com.zqx.po.Person;
import com.zqx.po.User;
import com.zqx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisAssociationTest {

    /**
     * 一对一
     */
    @Test
    public void findPersonById(){
        SqlSession sqlSession= MybatisUtil.getSession();
        Person person=sqlSession.selectOne(
                "com.zqx.mapper.PersonMapper.findPersonById",1);

        System.out.println(person);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 一对多
     */
    @Test
    public void findUserTest(){
        SqlSession sqlSession = MybatisUtil.getSession();
        User user =sqlSession.selectOne(
                "com.zqx.mapper"+".UserMapper.findUserByOrders",1);
        System.out.println(user);
        sqlSession.close();
    }



}
