package com.zqx.test;

import com.zqx.po.Person;
import com.zqx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisAssociationTest {
    @Test
    public void findPersonById(){
        SqlSession sqlSession= MybatisUtil.getSession();
        Person person=sqlSession.selectOne(
                "com.zqx.mapper"+".PersonMapper.findPersonById",1);

        System.out.println(person);
        sqlSession.commit();
        sqlSession.close();
    }
}
