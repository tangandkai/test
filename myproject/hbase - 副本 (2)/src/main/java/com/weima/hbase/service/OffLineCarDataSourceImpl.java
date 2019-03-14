package com.weima.hbase.service;

import com.weima.hbase.domain.dao.PheonixDataSourceDao;
import com.weima.hbase.result.PheonixDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffLineCarDataSourceImpl implements PheonixDataSourceDao {

    @Autowired
    @Qualifier("phoenixJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @Override
    public PheonixDataResult Add(String sql) {
        return null;
    }

    @Override
    public PheonixDataResult Delete(String sql) {
        return null;
    }

    @Override
    public PheonixDataResult Insert(String sql) {
        return null;
    }

    @Override
    public List Query(String sql) {
        return null;
    }

    @Override
    public Integer QueryTotalNum(String sql) {
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
