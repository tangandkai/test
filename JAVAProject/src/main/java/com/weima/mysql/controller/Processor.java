package com.weima.mysql.controller;

import com.weima.mysql.connection.JDBCN;
import com.weima.mysql.service.mapOperator;
import com.weima.mysql.utils.DataSourceInit;
import com.weima.mysql.utils.FileObject;
import com.weima.mysql.utils.GetTime;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Processor {

//    private static final Logger logger = Logger.getLogger(Processor.class);

    private static mapOperator mapoperator;
    public static void main(String[] args) throws IOException, SQLException {
        String query_sql_path = args[0];             //sql统计脚本路径
        String insert_sql_path = args[1];               //插入sql脚本路径
        String pro_path = args[2];              //jdbc配置文件路径
        String log_path = args[3];              //log配置文件路径
        String flag = args[4];                  //1:在同一数据源，0：在不同数据源

        String dataSource_0 = "";
        String dataSource_1 = "";
        if(flag.toString().equals("1")){
            dataSource_0 = "dataSource_0";
            dataSource_1 = "dataSource_0";
        }
        else if (flag.toString().equals("0")){
            dataSource_0 = "dataSource_0";
            dataSource_1 = "dataSource_1";
        }

        System.out.println("dataSource_0="+dataSource_0+"\n"+"dataSource_1="+dataSource_1);
        //log配置
        PropertyConfigurator.configure(log_path);
        Logger logger = Logger.getLogger(Processor.class);

        long starttime = System.currentTimeMillis();
        //配置时间
        Map<String, Object> time = GetTime.getTime();
        String satrtTime = time.get("startDate").toString();
        String currentTime = time.get("currentDate").toString();
        //用于查询，插入数据
        mapoperator = new mapOperator(log_path);

        //配置源数据源
        Map dataSource0 = DataSourceInit.dataSourceInit(pro_path, dataSource_1);

        //配置目的数据源
        Map dataSource1 = DataSourceInit.dataSourceInit(pro_path, dataSource_0);
        //读取查询sql模板文件
//        String querySql = FileObject.getSqlTemplate(query_sql_path);
        String querySql = MessageFormat.format(FileObject.getSqlTemplate(query_sql_path), currentTime,satrtTime);
        //读取插入sql模板文件
        String insertSql = FileObject.getSqlTemplate(insert_sql_path);


        //打印querySql模板内容
        System.out.println("querySql="+querySql);
        //打印insertSql模板内容
        System.out.println("insertSql="+insertSql);

        //获取源数据连接
        Connection queryConn = JDBCN.getConnection(dataSource0);

        //获取目的数据源连接
        Connection insertConn = JDBCN.getConnection(dataSource1);

        //源数据库统计结果
        List<StringBuffer> buffer = mapoperator.query(queryConn, querySql);
        long endtime = System.currentTimeMillis();
        logger.info("源表数据统计使用时间："+(endtime-starttime));

        //存储结果到目的数据库
        String result = mapoperator.insert(insertConn, insertSql, buffer);
        logger.info("插入使用时间："+(System.currentTimeMillis()-endtime));

        //遍历查询结果
        Iterator iter = dataSource0.entrySet().iterator();
        while (iter.hasNext()){
            System.out.println(iter.next().toString());
        }

        //释放数据库连接
        JDBCN.release(queryConn);
        JDBCN.release(insertConn);

    }
}
