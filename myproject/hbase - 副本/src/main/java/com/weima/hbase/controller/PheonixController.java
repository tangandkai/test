package com.weima.hbase.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.weima.hbase.result.*;
import com.weima.hbase.service.PheonixDataSourceDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PheonixController {

    @Autowired
    private PheonixDataSourceDaoImpl pheonixDataSourceService;

    @Autowired
    private Pageable pageable;

//    @Autowired
//    private ResponseResult responseResult;
//
//    @Autowired
//    private SignalContent signalContent;
//
//    @Autowired
//    private SignalResult signalResult;
    /**
     * 查询历史信号
     * @param vin
     * @param starttime
     * @param endtime
     * @param pagenumber
     * @param pagesize
     * @param sortby
     * @param order
     * @return
     */
    @GetMapping(value = "/v1/signals")
    public ResponseResult query(
            @RequestParam(value = "vin",required = true)String vin,
            @RequestParam(value = "startTime",required = true) BigInteger starttime,
            @RequestParam(value = "endTime",required = true)BigInteger endtime,
            @RequestParam(value = "pageNumber",required = false,defaultValue = "1") Integer pagenumber,
            @RequestParam(value = "pageSize",required = false,defaultValue = "20000") Integer pagesize,
            @RequestParam(value = "sortBy",required = false,defaultValue = "tboxTime")String sortby,
            @RequestParam(value = "order",required = false,defaultValue = "asc")String order
            ) throws Exception{

        Gson gson = new Gson();


        long time = System.currentTimeMillis();
        Integer offset = (pagenumber-1)*pagesize;

        String sql = String.format(
                "select \"iccid\",\"vin\",\"reissue\",\"tboxVersion\",\"tboxTime\",\"version\",\"parseTime\",\"items\",\"mappingItems\" from RVM_BIGDATA_ENV where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d order by \"%s\" %s limit %d offset %d","vin",vin,"tboxTime",starttime,"tboxTime",endtime,sortby,order,pagesize,offset);
        String sql_1 = String.format(
                "select count(*) from RVM_BIGDATA_ENV where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d","vin",vin,"tboxTime",starttime,"tboxTime",endtime);

        List<PheonixResult> content = pheonixDataSourceService.Query(sql);
        String jsonString = JSONArray.toJSONString(content);

//        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
//        String rr = gson.toJson(content);
//        System.out.println("对象转换为JSON结果："+jsonString);
        Integer totalElements = pheonixDataSourceService.QueryTotalNum(sql_1);
//        for(PheonixResult pheonixResult:content){
//            System.out.println("items转换结果:"+gson.fromJson(pheonixResult.getItems(),JsonObject.class));
//            System.out.println();
//        }
        Boolean paged = true;
        Integer totalPages = (int)Math.ceil(totalElements/pagesize);
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
//        System.out.println("---------------------------运行时间---------------------------");
//        System.out.println(System.currentTimeMillis()-time+"********************");
//        System.out.println("---------------------------结果大小---------------------------");
//        System.out.println(result.size());
//        System.out.println("------------------------------------------------------------");
//        System.out.println(responseResult.getContent().toString());
//        System.out.println(responseResult.toString());
//        String rrr = gson.toJson(responseResult);
//        System.out.println("responseResult转化结果="+rrr);
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

        String[] signal = signals.split(",");
        Integer offset = (pagenumber-1)*pagesize;
        String sql = String.format(
                "select \"iccid\",\"vin\",\"reissue\",\"tboxVersion\",\"tboxTime\",\"version\",\"parseTime\",\"items\",\"mappingItems\" from RVM_BIGDATA_ENV where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d order by \"%s\" %s limit %d offset %d","vin",vin,"tboxTime",starttime,"tboxTime",endtime,sortby,order,pagesize,offset);
        String sql_1 = String.format(
                "select count(*) from RVM_BIGDATA_ENV where \"%s\"=\'%s\' and \"%s\">=%d and \"%s\"<=%d","vin",vin,"tboxTime",starttime,"tboxTime",endtime);

        List<PheonixResult> content = pheonixDataSourceService.Query(sql);
        Integer totalElements = pheonixDataSourceService.QueryTotalNum(sql_1);

//        for(PheonixResult pheonixResult:content){
//            System.out.println(pheonixResult.getItems());
//        }
        Boolean paged = true;
        Integer totalPages = (int)Math.ceil(totalElements/pagesize);

        //用于存放解析后的信号
        List list = new ArrayList();

        List list_1 = new ArrayList();
        //封装分页信息
        pageable.setOffSet(offset);
        pageable.setPaged(paged);
        pageable.setPageNumber(pagenumber);
        pageable.setPageSize(pagesize);
        pageable.setTotalElements(totalElements);
        pageable.setSort(null);
        pageable.setTotalPages(totalPages);
        Gson gson = new Gson();

        //解析给定信号
        for(String s:signal){
            SignalResult signalResult = new SignalResult();
            for(PheonixResult pheonixResult:content){
                SignalContent signalContent = new SignalContent();
                BigInteger time = pheonixResult.getTboxTime();
//               System.out.println(time);
//               JsonObject json = gson.fromJson(pheonixResult.getItems(), JsonObject.class);
//                    JSONObject.parseObject(pheonixResult.getItems());
                JSONObject items = pheonixResult.getItems();
//                    JsonObject json = pheonixResult.getItems();
                signalContent.setT(time);               //封装时间
//                    String value = json.get(s).toString();  //获取指定信号的值
                String value = items.getObject(s, String.class);
                signalContent.setV(value);              //封装信号的值
//                    System.out.println(value);
                list.add(signalContent);

            }
            signalResult.setSignal(s);
            signalResult.setContent(list);
            list_1.add(signalResult);
        }
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(list_1);
        responseResult.setPageable(pageable);
        return responseResult;
    }
}
