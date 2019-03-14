package com.weima.service;

import com.weima.db.DBAccess;
import com.weima.entity.VehicleMap;
import com.weima.entity.tbControlCommandDistribution;
import com.weima.log.getLog;
import com.weima.mapper.mapMapper;
import com.weima.mapper.tbControlCommandDistributionMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.List;

public class tbControlCommandDistributionMapperImpl
        implements tbControlCommandDistributionMapper {

    private static Logger logger = getLog.logger();
    private String dataSource;
    private Timestamp timestamp;
    public tbControlCommandDistributionMapperImpl(String dataSource){this.dataSource=dataSource;}

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public List<tbControlCommandDistribution> findDistribute(Timestamp timestamp) {
        SqlSession sqlSession = null;
        List<tbControlCommandDistribution> tbMap = null;
        try{
            //获取sqlSession
            sqlSession = DBAccess.openSqlSession(dataSource);
            logger.info( sqlSession);
            tbControlCommandDistributionMapper tbMapper = sqlSession.getMapper(tbControlCommandDistributionMapper.class);
            logger.info(tbMapper);
            tbMap = tbMapper.findDistribute(timestamp);
        } catch (Exception e) {
            logger.error("查找出现问题",e);
        }
        finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return tbMap;
    }
}
