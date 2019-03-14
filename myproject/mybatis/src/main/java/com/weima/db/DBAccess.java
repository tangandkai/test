package com.weima.db;

import com.weima.log.getLog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class DBAccess {

    private static Logger logger = getLog.logger();
    private static final Class CLASS_LOCK = DBAccess.class;
    private static SqlSessionFactory sqlSessionFactory = null;
    private static SqlSessionFactory initSqlSessionFactory(String dataSource) {
        //读取配置文件，获取数据库连接信息
        String xmlPath = "mybatis-config.xml";
        InputStream inputStream = null;
        try{
            inputStream = Resources.getResourceAsStream(xmlPath);
        }catch (IOException e){
            logger.info("读取配置文件",e);
        }

        synchronized (CLASS_LOCK){
            if(sqlSessionFactory==null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,dataSource);
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession(String dataSource){
        if(sqlSessionFactory==null){
            sqlSessionFactory = initSqlSessionFactory(dataSource);
        }
        try{
            return sqlSessionFactory.openSession();
        }catch (Exception e){
            logger.error("连接数据库错误",e);
        }
        return null;
    }


//    public static void main(String[] args){
//        logger.info(openSqlSession());
//    }
}
