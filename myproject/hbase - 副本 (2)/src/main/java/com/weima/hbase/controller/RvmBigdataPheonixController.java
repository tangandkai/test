package com.weima.hbase.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.google.gson.JsonObject;
import com.weima.hbase.result.*;
import com.weima.hbase.result.ResponseResult;
import com.weima.hbase.result.signals.RvmBigdataResult;
import com.weima.hbase.result.signals.SignalContent;
import com.weima.hbase.result.signals.SignalResult;
import com.weima.hbase.service.RvmBigdataPheonixDataSourceDaoImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@RestController
//@RequestMapping("/")
public class RvmBigdataPheonixController {

    private static final Logger logger = Logger.getLogger(RvmBigdataPheonixController.class);
    @Autowired
    private RvmBigdataPheonixDataSourceDaoImpl pheonixDataSourceService;
//    @Autowired
//    private Pageable pageable;
//    @Autowired
//    private ResponseResult responseResult;
//    @Autowired
//    private SignalResult signalResult;
//    @Autowired
//    private SignalContent signalContent;


    //用于存放解析后的信号

    @GetMapping(value = "/v1/signals")
    public ResponseResult query(
            @RequestParam(value = "vin",required = true)String vin,
            @RequestParam(value = "startTime",required = true) BigInteger starttime,
            @RequestParam(value = "endTime",required = true)BigInteger endtime,
            @RequestParam(value = "pageNumber",required = false,defaultValue = "1") Integer pagenumber,
            @RequestParam(value = "pageSize",required = false,defaultValue = "20000") Integer pagesize,
            @RequestParam(value = "sortBy",required = false,defaultValue = "tboxTime")String sortby,
            @RequestParam(value = "order",required = false,defaultValue = "desc")String order
            )throws Exception{
        //获取当前时间
        long st = System.currentTimeMillis();
        logger.info("历史信号查询开始进入的时间："+st);

        Integer offset = (pagenumber-1)*pagesize;
//        String sql = String.format(
//                "select \"iccid\",\"vin\",\"reissue\",\"tboxVersion\",\"tboxTime\",\"version\",\"parseTime\",\"items\",\"mappingItems\" from RVM_BIGDATA_ENV where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d order by \"%s\" %s limit %d offset %d","vin",vin,"tboxTime",starttime,"tboxTime",endtime,sortby,order,pagesize,offset);
//        String sql_1 = String.format(
//                "select count(*) from RVM_BIGDATA_ENV where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d","vin",vin,"tboxTime",starttime,"tboxTime",endtime);
        String sql = String.format(
                "select * from RVM_BIGDATA_QA where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d order by \"%s\" %s limit %d offset %d","vin",vin,"tboxTime",starttime,"tboxTime",endtime,sortby,order,pagesize,offset);
        String sql_1 = String.format(
                "select count(*) from RVM_BIGDATA_QA where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d","vin",vin,"tboxTime",starttime,"tboxTime",endtime);
        logger.info("历史信号查询语句："+sql);
        logger.info("历史信号条数查询语句："+sql_1);
//        long s1 = calendar.getTimeInMillis();
        long s1 = System.currentTimeMillis();
        List<RvmBigdataResult> content = pheonixDataSourceService.Query(sql);
//        logger.info("历史信号查询使用时间："+(calendar.getTimeInMillis()-s1));
        logger.info("历史信号查询使用时间："+(System.currentTimeMillis()-s1));
//        long s2 = calendar.getTimeInMillis();
        long s2 = System.currentTimeMillis();
        Integer totalElements = pheonixDataSourceService.QueryTotalNum(sql_1);
//        logger.info("历史信号总条数查询使用时间："+(calendar.getTimeInMillis()-s2));
        logger.info("历史信号总条数查询使用时间："+(System.currentTimeMillis()-s2));
        Boolean paged = true;
        Integer totalPages = (int)Math.ceil(totalElements/pagesize);

        Pageable pageable = new Pageable();
        pageable.setOffSet(offset);
        pageable.setPaged(paged);
        pageable.setPageNumber(pagenumber);
        pageable.setPageSize(pagesize);
        pageable.setTotalElements(totalElements);
        pageable.setSort(null);
        pageable.setTotalPages(totalPages);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(content);
        responseResult.setPageable(pageable);
        logger.info("历史信号查询执行完一次使用时间："+(System.currentTimeMillis()-st));
        return responseResult;
    }

    /**
     * 查询特定信号
     * @param vin
     * @param starttime
     * @param endtime
     * @param pagenumber
     * @param pagesize
     * @param sortby
     * @param order
     * @param signals
     */
    @GetMapping(value = "/v1/multipleSignals")
    public ResponseResult query_2(
            @RequestParam(value = "vin",required = true)String vin,
            @RequestParam(value = "startTime",required = true) BigInteger starttime,
            @RequestParam(value = "endTime",required = true)BigInteger endtime,
            @RequestParam(value = "pageNumber",required = false,defaultValue = "1") Integer pagenumber,
            @RequestParam(value = "pageSize",required = false,defaultValue = "20000") Integer pagesize,
            @RequestParam(value = "sortBy",required = false,defaultValue = "tboxTime")String sortby,
            @RequestParam(value = "order",required = false,defaultValue = "asc")String order,
            @RequestParam(value = "signals",required = true)String signals
    )throws Exception{
        long st = System.currentTimeMillis();
        logger.info("单车多信号查询进入时间："+st);
        String[] signal = signals.split(",");
        Integer offset = (pagenumber-1)*pagesize;
//        String sql = String.format(
//                "select \"iccid\",\"vin\",\"reissue\",\"tboxVersion\",\"tboxTime\",\"version\",\"parseTime\",\"items\",\"mappingItems\" from RVM_BIGDATA_ENV where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d order by \"%s\" %s limit %d offset %d","vin",vin,"tboxTime",starttime,"tboxTime",endtime,sortby,order,pagesize,offset);
//        String sql_1 = String.format(
//                "select count(*) from RVM_BIGDATA_ENV where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d","vin",vin,"tboxTime",starttime,"tboxTime",endtime);

        String sql = String.format(
                "select * from RVM_BIGDATA_QA where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d order by \"%s\" %s limit %d offset %d","vin",vin,"tboxTime",starttime,"tboxTime",endtime,sortby,order,pagesize,offset);
        String sql_1 = String.format(
                "select count(*) from RVM_BIGDATA_QA where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d","vin",vin,"tboxTime",starttime,"tboxTime",endtime);
        logger.info("单车多信号查询语句："+sql);
        logger.info("单车多信号记录条数查询语句："+sql_1);

        long s1 = System.currentTimeMillis();
        List<RvmBigdataResult> content = pheonixDataSourceService.Query(sql);

        logger.info("单车多信号查询使用时间："+(System.currentTimeMillis()-s1));

        long s2 = System.currentTimeMillis();
        Integer totalElements = pheonixDataSourceService.QueryTotalNum(sql_1);

        logger.info("单车多信号条数查询使用时间："+(System.currentTimeMillis()-s2));
        Boolean paged = true;
        Integer totalPages = (int)Math.ceil(totalElements/pagesize);


        //封装分页信息
        Pageable pageable = new Pageable();
        pageable.setOffSet(offset);
        pageable.setPaged(paged);
        pageable.setPageNumber(pagenumber);
        pageable.setPageSize(pagesize);
        pageable.setTotalElements(totalElements);
        pageable.setSort(null);
        pageable.setTotalPages(totalPages);

        List<SignalResult> list_1 = new ArrayList();

        long ss = System.currentTimeMillis();
        //解析给定信号
        logger.info("开始解析信号");
        for(String s:signal){
            List<SignalContent> list = new ArrayList();
            logger.info("正在解析的信号是："+s);
            for(RvmBigdataResult rvmBigdataResult:content){
                SignalContent signalContent = new SignalContent();
                BigInteger time = rvmBigdataResult.getTboxTime();
                JSONObject items = rvmBigdataResult.getItems();
                String value = items.getObject(s,String.class);
                signalContent.setT(time);               //封装时间
                signalContent.setV(value);              //封装信号的值
                logger.info("解析的信号结果是："+signalContent.toString());
                list.add(signalContent);
            }
//            logger.info("解析完"+s+"信号使用时间："+(calendar.getTimeInMillis()-ss));
            logger.info("解析完"+s+"信号的时间："+System.currentTimeMillis()+"使用时间："+(System.currentTimeMillis()-ss));
            SignalResult signalResult = new SignalResult();
            signalResult.setSignal(s);
            signalResult.setContent(list);
//            System.out.println("信号解析结果："+signalResult.toString());
            list_1.add(signalResult);
        }
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(list_1);
        responseResult.setPageable(pageable);
//        logger.info("执行完单车多信号查询使用时间："+(calendar.getTimeInMillis()-st));
        logger.info("执行完单车多信号查询使用时间："+(System.currentTimeMillis()-st));
        return responseResult;
    }
}
