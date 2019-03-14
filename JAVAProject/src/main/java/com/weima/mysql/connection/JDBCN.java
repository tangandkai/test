package com.weima.mysql.connection;


import com.alibaba.druid.pool.DruidDataSource;
import com.weima.mysql.utils.PropertyUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JDBCN{

    private String path;
    private static volatile DruidDataSource druidDataSource;
//    public JDBCN(String path) {this.path = path;}


    private static DataSource dataSource(Map map){
        druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(map.get("url").toString());
        druidDataSource.setDriverClassName(map.get("driver").toString());
        druidDataSource.setUsername(map.get("username").toString());
        druidDataSource.setPassword(map.get("password").toString());

        druidDataSource.setInitialSize(Integer.parseInt(map.get("initialsize").toString()));
        druidDataSource.setMaxActive(Integer.parseInt(map.get("maxactive").toString()));
        return druidDataSource;
    }

    public static Connection getConnection(Map map){
        try {
            return dataSource(map).getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//    public static void main(String[] args) throws SQLException {
//        Properties pro = PropertyUtils.getInstance().getProperties
//                ("C:\\software\\IDEA\\IDEAProject\\JAVAProject\\src\\main\\resource\\jdbc.properties");
//        Map<String,String> map = new HashMap<>();
//        map.put("driver",pro.getProperty("driver"));
//        map.put("url",pro.getProperty("one.url"));
//        map.put("username",pro.getProperty("one.username"));
//        map.put("password",pro.getProperty("one.password"));
//        map.put("initialsize",pro.getProperty("initialsize"));
//        map.put("maxactive",pro.getProperty("maxactive"));
//        Connection conn = getConnection(map);
//        System.out.println("conn="+conn);
//        conn.close();
//    }
}