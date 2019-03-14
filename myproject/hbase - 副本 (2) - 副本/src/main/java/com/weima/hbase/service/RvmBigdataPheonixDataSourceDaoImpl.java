package com.weima.hbase.service;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.weima.hbase.domain.dao.PheonixDataSourceDao;
import com.weima.hbase.result.PheonixDataResult;
import com.weima.hbase.result.signals.RvmBigdataResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Service
public class RvmBigdataPheonixDataSourceDaoImpl implements PheonixDataSourceDao {
    private static final Logger logger = Logger.getLogger(RvmBigdataPheonixDataSourceDaoImpl.class);

    @Autowired
    @Qualifier("phoenixJdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    /**
     * 执行插入操作
     * @param sql
     * @return
     */
    @Override
    public PheonixDataResult Add(String sql) {
        return jdbcTemplate.update(sql)==1?new PheonixDataResult(true,"插入成功"):
                new PheonixDataResult(false,"插入失败");
    }

    /**
     * 执行删除操作
     * @param sql
     * @return
     */
    @Override
    public PheonixDataResult Delete(String sql) {
        return jdbcTemplate.update(sql)==1?new PheonixDataResult(true,"删除成功"):
                new PheonixDataResult(false,"删除失败");
    }

    /**
     * 执行插入操作
     * @param sql
     * @return
     */
    @Override
    public PheonixDataResult Insert(String sql) {
        return jdbcTemplate.update(sql)==1?new PheonixDataResult(true,"插入成功"):
                new PheonixDataResult(false,"插入失败");
    }

    /**
     * private String iccid;
     *     private String vin;
     *     private Boolean reissue;
     *     private String tboxVersion;
     *     private BigInteger tboxTime;
     *     private Integer version;
     *     private BigInteger parseTime;
     *     private JsonObject items;
     *     private String mappingItems;
     */
    /**
     * 执行查询操作
     * @param sql
     * @return
     */
    @Override
    public List<RvmBigdataResult> Query(String sql) {
        long s1 = System.currentTimeMillis();
        logger.debug("开始信号查询。。。。时间是："+s1);
//        List<RvmBigdataResult>result = jdbcTemplate.query(sql, new BeanPropertyRowMapper(RvmBigdataResult.class));
        List<RvmBigdataResult> query = jdbcTemplate.query(sql, new RowMapper<RvmBigdataResult>() {
            @Override
            public RvmBigdataResult mapRow(ResultSet rs, int rowNum) throws SQLException {
                RvmBigdataResult rvmBigdataResult = new RvmBigdataResult(); //特别需要new，不然如果结果集是list就只有1个对象
                rvmBigdataResult.setVin(rs.getString("vin"));
                rvmBigdataResult.setIccid(rs.getString("iccid"));
                rvmBigdataResult.setReissue(rs.getBoolean("reissue"));
                rvmBigdataResult.setTboxVersion(rs.getString("tboxVersion"));
                rvmBigdataResult.setTboxTime(new BigInteger(rs.getString("tboxTime")));
                rvmBigdataResult.setVersion(rs.getString("version"));
                rvmBigdataResult.setParseTime(new BigInteger(rs.getString("parseTime")));
                rvmBigdataResult.setItems(JSONObject.parseObject(rs.getString("items")));
                String mappingItems = rs.getString("mappingItems");
                if(null==mappingItems){
                    rvmBigdataResult.setMappingItems(null);
                }
                else
                    rvmBigdataResult.setMappingItems(JSONObject.parseObject(mappingItems));
                return rvmBigdataResult;
            }});
        logger.debug("信号查询完毕。。。。时间是："+System.currentTimeMillis()+"使用时间是："+(System.currentTimeMillis()-s1));
        return query;
//        return result;
    }

    @Override
    public Integer QueryTotalNum(String sql) {
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
