package com.weima.hbase.service;

import com.weima.hbase.domain.dao.PheonixDataSourceDao;
import com.weima.hbase.result.PheonixDataResult;
import com.weima.hbase.result.altercode.AlterCodeFaultList;
import com.weima.hbase.result.signals.RvmBigdataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class AlterCodePheonixDataSourceImpl implements PheonixDataSourceDao {

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
        List<AlterCodeFaultList> faultList = jdbcTemplate.query(sql, new RowMapper<AlterCodeFaultList>() {
            @Override
            public AlterCodeFaultList mapRow(ResultSet rs, int rowNum) throws SQLException {
                AlterCodeFaultList alterCodeFaultList = new AlterCodeFaultList();
                alterCodeFaultList.setAlterCode(rs.getString("alert_code"));
                alterCodeFaultList.setNum(rs.getLong("num"));
                return alterCodeFaultList;
            }
        });
        return faultList;
    }

    @Override
    public Integer QueryTotalNum(String sql) {
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
