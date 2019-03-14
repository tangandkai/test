package com.weima.service;

import com.weima.db.DBAccess;
import com.weima.entity.VehicleMap;
import com.weima.log.getLog;
import com.weima.mapper.mapMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.List;

/**
 * 地图数据处理
 */
public class mapMapperImpl implements mapMapper {

    private static Logger logger = getLog.logger();
    private String dataSource;

    public mapMapperImpl(String dataSource) {this.dataSource = dataSource;}

    @Override
    public List<VehicleMap> findAll() {
        SqlSession sqlSession = null;
        List<VehicleMap> vehicleMap = null;
        try{
            //获取sqlSession
            sqlSession = DBAccess.openSqlSession(dataSource);
            logger.info( sqlSession);
            mapMapper mapper = sqlSession.getMapper(mapMapper.class);
            logger.info(mapper);
            vehicleMap = mapper.findAll();
        } catch (Exception e) {
            logger.error("查找出现问题",e);
        }
        finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return vehicleMap;
    }

    @Override
    public void insert(VehicleMap vehicleMap) {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBAccess.openSqlSession(dataSource);
            logger.info( sqlSession);
            mapMapper mapper = sqlSession.getMapper(mapMapper.class);
            logger.info(mapper);
            mapper.insert(vehicleMap);
            sqlSession.commit();
        }catch (Exception e){
            logger.error(e);
        }
    }
}
