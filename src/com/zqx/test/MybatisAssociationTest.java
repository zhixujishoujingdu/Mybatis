package com.zqx.test;

import com.zqx.po.Orders;
import com.zqx.po.Person;
import com.zqx.po.User;
import com.zqx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.core.annotation.Order;

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
                "com.zqx.mapper"+".UserMapper.findUserWithOrders",1);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 多对多
     */
    @Test
    public void findOrdersWithProductTest(){

        SqlSession sqlSession = MybatisUtil.getSession();
        Orders orders =sqlSession.selectOne(
                "com.zqx.mapper"+
                        ".OrdersMapper.findOrdersWithProduct",1);
        System.out.println(orders);
        sqlSession.close();
    }



}
