package com.weima.hbase.service;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.weima.hbase.domain.dao.PheonixDataSourceDao;
import com.weima.hbase.result.PheonixDataResult;
import com.weima.hbase.result.PheonixResult;
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
import java.util.Map;

@Component
@Service
public class PheonixDataSourceDaoImpl implements PheonixDataSourceDao {


    @Autowired
    @Qualifier("phoenixJdbcTemplate")
    JdbcTemplate jdbcTemplate;


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
    public List<PheonixResult> Query(String sql) {
        Gson gson = new Gson();
        int i = 1;
//        List<PheonixResult>result = jdbcTemplate.query(sql, new BeanPropertyRowMapper(PheonixResult.class));
        List<PheonixResult> query = jdbcTemplate.query(sql, new RowMapper<PheonixResult>() {
            @Override
            public PheonixResult mapRow(ResultSet rs, int rowNum) throws SQLException {
                PheonixResult pheonixResult = new PheonixResult(); //特别需要new，不然如果结果集是list就只有1个对象
                pheonixResult.setVin(rs.getString("vin"));
                pheonixResult.setIccid(rs.getString("iccid"));
                pheonixResult.setReissue(rs.getBoolean("reissue"));
                pheonixResult.setTboxVersion(rs.getString("tboxVersion"));
                pheonixResult.setTboxTime(new BigInteger(rs.getString("tboxTime")));
                pheonixResult.setVersion(rs.getString("version"));
                pheonixResult.setParseTime(new BigInteger(rs.getString("parseTime")));
                pheonixResult.setItems(JSONObject.parseObject(rs.getString("items")));
                String mappingItems = rs.getString("mappingItems");
                if(null==mappingItems){
                    pheonixResult.setMappingItems(null);
                }
                else
                    pheonixResult.setMappingItems(JSONObject.parseObject(mappingItems));
//                pheonixResult.setMappingItems(rs.getString("mappingItems"));
                gson.toJson(pheonixResult);
                return pheonixResult;
            }});
        return query;
//        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> qq(String sql){
        return jdbcTemplate.queryForList(sql);
    }
    @Override
    public Integer QueryTotalNum(String sql) {
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
