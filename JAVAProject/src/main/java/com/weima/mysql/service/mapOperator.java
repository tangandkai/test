package com.weima.mysql.service;

import com.weima.mysql.dao.mapMessageDao;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.io.IOException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.*;

public class mapOperator implements mapMessageDao {


    private String path;

    public mapOperator(String path) {
        this.path = path;
    }

    @Override
    public List query(Connection conn,String sql) throws SQLException, IOException {

        PropertyConfigurator.configure(path);
        Logger logger = Logger.getLogger(mapOperator.class);
        logger.info("conn="+conn);
        Statement stmt = conn.createStatement();
        System.out.println("要执行的sql语句是："+sql);
        ResultSet rs = stmt.executeQuery(sql);
        List<StringBuffer> list = new ArrayList();
        while (rs.next()){
            //存放查找到的字段值
            StringBuffer buffer = new StringBuffer();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                buffer.append(rs.getObject(i)).append(",");
            }
            list.add(buffer.deleteCharAt(buffer.length()-1));
        }
        rs.close();
        stmt.close();
        return list;
    }

    @Override
    public String insert(Connection conn,String sql,List<?> content) throws SQLException {
        PropertyConfigurator.configure(path);
        Logger logger = Logger.getLogger(mapOperator.class);
        Statement stmt = conn.createStatement();
        Iterator<?> iter = content.iterator();
        while (iter.hasNext()){
            String s = MessageFormat.format(sql,iter.next().toString().split(","));
            logger.info("插入的sql语句："+s);
            stmt.addBatch(s);
        }
        stmt.executeBatch();
        stmt.close();
        return "插入成功";
    }


}
