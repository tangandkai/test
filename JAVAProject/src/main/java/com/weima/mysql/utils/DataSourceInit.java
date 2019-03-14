package com.weima.mysql.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DataSourceInit {

    /**
     *
     * @param dataSourcePath 配置文件路径
     * @param dataSource 选择哪个配置
     * @return
     */
    public static Map dataSourceInit(String dataSourcePath, String dataSource){
        Properties pro = PropertyUtils.getInstance().getProperties(dataSourcePath);
        System.out.println("dataSource="+dataSource);
        Map<String,String> map = new HashMap<String,String>();
        map.put("driver",pro.getProperty("driver"));
        map.put("url",pro.getProperty(String.format("%s.url",dataSource)));
        map.put("username",pro.getProperty(String.format("%s.username",dataSource)));
        map.put("password",pro.getProperty(String.format("%s.password",dataSource)));
        map.put("initialsize",pro.getProperty("initialsize"));
        map.put("maxactive",pro.getProperty("maxactive"));
//        Connection conn = JDBCN.getConnection(map);
//        Statement stmt = conn.createStatement();
        return map;
    }
}
