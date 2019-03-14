package com.weima.hbase.domain.dao;

import com.weima.hbase.result.PheonixDataResult;

import java.util.List;
import java.util.Map;

public interface PheonixDataSourceDao<T> {

    /**
     * 添加数据
     * @return
     */
    PheonixDataResult Add(String sql);

    /**
     * 删除数据
     * @return
     */
    PheonixDataResult Delete(String sql);

    /**
     * 插入数据
     * @return
     */
    PheonixDataResult Insert(String sql);

    /**
     * 查询数据,多条
     * @return
     */
    List<T> Query(String sql);

    /**
     * @param sql
     * @return
     */
    Integer QueryTotalNum(String sql);

}
