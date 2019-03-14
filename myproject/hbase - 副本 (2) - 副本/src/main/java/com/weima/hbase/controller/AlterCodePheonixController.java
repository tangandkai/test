package com.weima.hbase.controller;


import com.weima.hbase.result.Pageable;

import com.weima.hbase.result.altercode.AlertCodeResponseResult;
import com.weima.hbase.result.altercode.AlterCodeTotalVehicle;
import com.weima.hbase.service.AlterCodePheonixDataSourceImpl;
import com.weima.hbase.service.OffLineCarDataSourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("/")
public class AlterCodePheonixController {


    @Autowired
    private AlterCodePheonixDataSourceImpl alterCodePheonixDataSource;
    @Autowired
    private OffLineCarDataSourceImpl offLineCarDataSource;
//    @Autowired
//    private Pageable pageable;
//    @Autowired
//    private AlterCodeTotalVehicle alterCodeTotalVehicle;
//    @Autowired
//    private AlertCodeResponseResult alertCodeResponseResult;

    @Value("${alter_code.alter_statistics}")
    private String alter_statistics;

    @Value("${alter_code.alter_car_num}")
    private String alter_car_num;

    @Value("${alter_code.offline_num}")
    private String offline_num;

    @Value("${alter_code.alter_total_num}")
    private String alter_total_num;

    @RequestMapping(value = "/v1/faultStatistics")
    public AlertCodeResponseResult query_1(
            @RequestParam(value = "startTime",required = true) String starttime,
            @RequestParam(value = "endTime",required = true)String endtime,
            @RequestParam(value = "pageNumber",required = false,defaultValue = "1") Integer pagenumber,
            @RequestParam(value = "pageSize",required = false,defaultValue = "20000") Integer pagesize,
            @RequestParam(value = "sortBy",required = false,defaultValue = "alert_start_time")String sortby,
            @RequestParam(value = "order",required = false,defaultValue = "asc")String order
    ){
        Integer offset = (pagenumber-1)*pagesize;
//        String sql = String.format(
////                "select \"alert_code\",count(distinct \"vin\") as \"num\" from RVM_ALERT_RECORD_DIST where \"%s\">=%d and \"%s\"<=%d group by \"alert_code\" limit %d offset %d","alert_start_time",starttime,"alert_start_time",endtime,pagesize,offset);
////        String sql_1 = String.format("select count(*) from RVM_ALERT_RECORD_DIST where \"%s\">=%d and \"%s\"<=%d","alert_start_time",starttime,"alert_start_time",endtime);
////
////        String sql_2 = String.format("select count(distinct \"vin\") from RVM_ALERT_RECORD_DIST where \"%s\">=%d and \"%s\"<=%d","alert_start_time",starttime,"alert_start_time",endtime);
////        String sql_3 = String.format("select count(\"vin\") from TB_ACCOUNT_OFFLINE_BOUND_STATUS_MID");

        String sql_new = MessageFormat.format(alter_statistics,starttime,endtime,pagesize,offset);
        String sql_1_new = MessageFormat.format(alter_total_num,starttime,endtime);
        String sql_2_new = MessageFormat.format(alter_car_num,starttime,endtime);
        String sql_3_new = MessageFormat.format(offline_num,starttime,endtime);

        Integer totalElements = alterCodePheonixDataSource.QueryTotalNum(sql_1_new);
        Integer totalFaultVehicle = alterCodePheonixDataSource.QueryTotalNum(sql_2_new);
        Integer totalPages = (int)Math.ceil(totalElements/pagesize);
        //获取下线车辆数目
        Integer totalVehicle = offLineCarDataSource.QueryTotalNum(sql_3_new);
        //
        List faultList = alterCodePheonixDataSource.Query(sql_new);
        //分页
        Pageable pageable = new Pageable();
        pageable.setOffSet(offset);
        pageable.setPaged(true);
        pageable.setPageNumber(pagenumber);
        pageable.setPageSize(pagesize);
        pageable.setTotalElements(totalElements);
        pageable.setSort(null);
        pageable.setTotalPages(totalPages);
        //
        AlterCodeTotalVehicle alterCodeTotalVehicle = new AlterCodeTotalVehicle();
        alterCodeTotalVehicle.setFaultList(faultList);
        alterCodeTotalVehicle.setTotalFaultVehicle(totalFaultVehicle);
        alterCodeTotalVehicle.setTotalVehicle(totalVehicle);
        //
        AlertCodeResponseResult alertCodeResponseResult = new AlertCodeResponseResult();
        alertCodeResponseResult.setPageable(pageable);
        alertCodeResponseResult.setContent(alterCodeTotalVehicle);
        return alertCodeResponseResult;
    }
}
