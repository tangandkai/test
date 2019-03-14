package com.weima.service;

import com.weima.db.DBAccess;
import com.weima.entity.Girl;
import com.weima.log.getLog;
import com.weima.mapper.girlMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class girlMapperImpl implements girlMapper {

    private static Logger logger = getLog.logger();
    private String dataSource;
    public girlMapperImpl(String dataSource){this.dataSource = dataSource;}

    @Override
    public List<Girl> findAll() {
        SqlSession sqlSession = null;
        List<Girl> girls = null;
        try{
            //获取sqlSession
            sqlSession = DBAccess.openSqlSession(dataSource);
            logger.info( sqlSession);
            girlMapper girlMapper = sqlSession.getMapper(girlMapper.class);
            logger.info(girlMapper);
            girls = girlMapper.findAll();
        } catch (Exception e) {
            logger.error("查找出现问题",e);
        }
        finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return girls;
    }

    @Override
    public void insert(Girl girl) {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBAccess.openSqlSession(dataSource);
            logger.info( sqlSession);
            girlMapper girlMapper = sqlSession.getMapper(girlMapper.class);
            logger.info(girlMapper);
            girlMapper.insert(girl);
            sqlSession.commit();
        }catch (Exception e){
            logger.error(e);
        }
    }
}
