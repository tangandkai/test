package com.weima.hbase.controller;

import com.alibaba.fastjson.JSONObject;

import com.weima.hbase.result.*;
import com.weima.hbase.result.ResponseResult;
import com.weima.hbase.result.signals.RvmBigdataResult;
import com.weima.hbase.result.signals.SignalContent;
import com.weima.hbase.result.signals.SignalResult;
import com.weima.hbase.service.RvmBigdataPheonixDataSourceDaoImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@RestController
public class RvmBigdataPheonixController {

    private static final Logger logger = Logger.getLogger(RvmBigdataPheonixController.class);
    @Autowired
    private RvmBigdataPheonixDataSourceDaoImpl pheonixDataSourceService;

    @Value("${rvm_bigdata.signals_statistics}")
    private String signals_statistics;

    @Value("${rvm_bigdata.signals_count}")
    private String signals_count;

    @Value("${rvm_bigdata.multipleSignals_statistics}")
    private String multipleSignals_statistics;

    @Value("${rvm_bigdata.multipleSignals_count}")
    private String multipleSignals_count;

    //用于存放解析后的信号

    @GetMapping(value = "/v1/signals")
    public ResponseResult query(
            @RequestParam(value = "vin",required = true)String vin,
            @RequestParam(value = "startTime",required = true) String starttime,
            @RequestParam(value = "endTime",required = true)String endtime,
            @RequestParam(value = "pageNumber",required = false,defaultValue = "1") Integer pagenumber,
            @RequestParam(value = "pageSize",required = false,defaultValue = "20000") Integer pagesize,
            @RequestParam(value = "sortBy",required = false,defaultValue = "tboxTime")String sortby,
            @RequestParam(value = "order",required = false,defaultValue = "desc")String order
            )throws Exception{
        //获取当前时间
        long st = System.currentTimeMillis();
        logger.info("历史信号查询开始进入的时间："+st);

        Integer offset = (pagenumber-1)*pagesize;

        String format_vin = "\'"+vin+"\'";
        String sql_new = MessageFormat.format(signals_statistics,format_vin,starttime,endtime,sortby,order,pagesize,offset);
        String sql_1_new = MessageFormat.format(signals_count,format_vin,starttime,endtime);
        logger.info("历史信号查询语句："+sql_new);
        logger.info("历史信号条数查询语句："+sql_1_new);

        long s1 = System.currentTimeMillis();
        List<RvmBigdataResult> content = pheonixDataSourceService.Query(sql_new);

        logger.info("历史信号查询使用时间："+(System.currentTimeMillis()-s1));
        long s2 = System.currentTimeMillis();
        Integer totalElements = pheonixDataSourceService.QueryTotalNum(sql_1_new);

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
            @RequestParam(value = "startTime",required = true) String starttime,
            @RequestParam(value = "endTime",required = true)String endtime,
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

        String format_vin = "\'"+vin+"\'";
        String sql_new = MessageFormat.format(multipleSignals_statistics,format_vin,starttime,endtime,sortby,order,pagesize,offset);
        String sql_1_new = MessageFormat.format(multipleSignals_count,format_vin,starttime,endtime);
        logger.info("单车多信号查询语句："+sql_new);
        logger.info("单车多信号记录条数查询语句："+sql_1_new);

        long s1 = System.currentTimeMillis();
        List<RvmBigdataResult> content = pheonixDataSourceService.Query(sql_new);

        logger.info("单车多信号查询使用时间："+(System.currentTimeMillis()-s1));

        long s2 = System.currentTimeMillis();
        Integer totalElements = pheonixDataSourceService.QueryTotalNum(sql_1_new);

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
            logger.info("解析完"+s+"信号的时间："+System.currentTimeMillis()+"使用时间："+(System.currentTimeMillis()-ss));
            SignalResult signalResult = new SignalResult();
            signalResult.setSignal(s);
            signalResult.setContent(list);
            list_1.add(signalResult);
        }
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(list_1);
        responseResult.setPageable(pageable);

        logger.info("执行完单车多信号查询使用时间："+(System.currentTimeMillis()-st));
        return responseResult;
    }
}
