package com.weima.hbase.controller;


import com.weima.hbase.result.Pageable;
import com.weima.hbase.result.ResponseResult;
import com.weima.hbase.service.LatestReportDataSourceImpl;
import com.weima.hbase.utils.TimeChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class LatestReportLocationPhenoixController {

    @Autowired
    private LatestReportDataSourceImpl latestReportDataSource;

//    @Autowired
//    private Pageable pageable;

    @Autowired
    private TimeChange timeChange;

//    @Autowired
//    private ResponseResult responseResult;

    @Value("${last_report.last_statistics}")
    private String last_statistics;

    @Value("${last_report.last_num}")
    private String last_num;

    @RequestMapping("/v1/vehicleLatestSignalsTime")
    public ResponseResult query_1(
            @RequestParam(value = "day",required = false,defaultValue = "3")Integer day,
            @RequestParam(value = "pageNumber",required = false,defaultValue = "1") Integer pagenumber,
            @RequestParam(value = "pageSize",required = false,defaultValue = "20000") Integer pagesize,
            @RequestParam(value = "sortBy",required = false,defaultValue = "latest_report_time")String sortby,
            @RequestParam(value = "order",required = false,defaultValue = "asc")String order
    ){

        //获取day天前的时间戳（精确到毫秒）
        Map<String, Object> time = timeChange.getTime(day);
        BigInteger timeStamp = new BigInteger(time.get("timeStamp").toString());

        Integer offset = (pagenumber-1)*pagesize;

        String sql_new = MessageFormat.format(last_statistics,timeStamp,sortby,order,pagesize,offset);
        String sql_1_new = MessageFormat.format(last_num,timeStamp);

        //获取给定条件下查找到的元素数目
        Integer totalElements = latestReportDataSource.QueryTotalNum(sql_1_new);
        //分页数
        Integer totalPages = (int)Math.ceil(totalElements/pagesize);
        //获取给定条件下查找到的元素
        List content = latestReportDataSource.Query(sql_new);

        //封装分页信息
        Pageable pageable = new Pageable();
        pageable.setOffSet(offset);
        pageable.setPaged(true);
        pageable.setPageNumber(pagenumber);
        pageable.setPageSize(pagesize);
        pageable.setTotalElements(totalElements);
        pageable.setSort(null);
        pageable.setTotalPages(totalPages);

        //封装返回给前端的数据
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(content);
        responseResult.setPageable(pageable);
        return responseResult;
    }
}
