package com.weima.hbase.service;


import com.weima.hbase.domain.dao.PheonixDataSourceDao;
import com.weima.hbase.result.PheonixDataResult;
import com.weima.hbase.result.latestreport.LatestReportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class LatestReportDataSourceImpl implements PheonixDataSourceDao {


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
        List<LatestReportResult> LatestResult = jdbcTemplate.query(sql, new RowMapper<LatestReportResult>(){
            @Override
            public LatestReportResult mapRow(ResultSet rs, int rowNum) throws SQLException {
                LatestReportResult latestReportResult = new LatestReportResult();
                latestReportResult.setVin(rs.getString("vin"));
                latestReportResult.setLatestReportTime(new BigInteger(rs.getString("latest_report_time")));
                latestReportResult.setPlatform(rs.getString("platform"));
                latestReportResult.setLatitude(rs.getBigDecimal("latitude"));
                latestReportResult.setLongitude(rs.getBigDecimal("longitude"));
                return latestReportResult;
            }
        });
        return LatestResult;
    }

    @Override
    public Integer QueryTotalNum(String sql) {
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
