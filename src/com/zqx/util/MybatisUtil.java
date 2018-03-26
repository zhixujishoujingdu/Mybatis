package com.zqx.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;


/**
 * 工具类
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory=null;

    //        初始化SqlSessionFactory对象
    static{
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//            构建SqlSessionFactory工厂
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //        获取SqlSession对象的静态方法
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }

}
