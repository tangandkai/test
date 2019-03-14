package com.weima.hbase.controller;

import com.alibaba.fastjson.JSONObject;
import com.weima.hbase.result.Pageable;
import com.weima.hbase.result.ResponseResult;
import com.weima.hbase.result.signals.RvmBigdataResult;
import com.weima.hbase.result.signals.SignalContent;
import com.weima.hbase.result.signals.SignalResult;
import com.weima.hbase.service.RvmBigdataPheonixDataSourceDaoImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RvmBigdataPheonixController {

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

    public ResponseResult query()throws Exception{
        List<RvmBigdataResult> content = new ArrayList<>();
        Integer offset = (1-1)*100;
        RvmBigdataResult rvmBigdataResult = new RvmBigdataResult();
        String item_0 = "{VCU_VhclActlGearPos=1.0, GPS_Status=1.0, TPMS_PressureValue_RR=701.25, TPMS_PressureValue_FL=701.25, ESC_VehicleSpeed=0.0}";
        rvmBigdataResult.setItems(JSONObject.parseObject(item_0));
        rvmBigdataResult.setTboxTime(new BigInteger("452146238742"));
        content.add(rvmBigdataResult);
        Integer totalElements = 1000;
        Boolean paged = true;
        Integer totalPages = (int)Math.ceil(totalElements/100);

        Pageable pageable = new Pageable();
        pageable.setOffSet(offset);
        pageable.setPaged(paged);
        pageable.setPageNumber(1);
        pageable.setPageSize(100);
        pageable.setTotalElements(totalElements);
        pageable.setSort(null);
        pageable.setTotalPages(totalPages);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(content);
        responseResult.setPageable(pageable);
        return responseResult;
    }


    public ResponseResult query_2(String signals)throws Exception{
        String[] signal = signals.split(",");
        Integer offset = (1-1)*100;
        List<RvmBigdataResult> content = new ArrayList<>();
        RvmBigdataResult rvmBigdataResult1 = new RvmBigdataResult();
        String item_0 = "{VCU_VhclActlGearPos:1.0, GPS_Status:1.0, TPMS_PressureValue_RR:701.25, TPMS_PressureValue_FL:701.25, ESC_VehicleSpeed:0.0}";
        rvmBigdataResult1.setItems(JSONObject.parseObject(item_0));
        rvmBigdataResult1.setTboxTime(new BigInteger("452146238742"));
        content.add(rvmBigdataResult1);

        Boolean paged = true;
        Integer totalPages = (int)Math.ceil(1000/100);


        //封装分页信息
        Pageable pageable = new Pageable();
        pageable.setOffSet(offset);
        pageable.setPaged(paged);
        pageable.setPageNumber(1);
        pageable.setPageSize(100);
        pageable.setTotalElements(1000);
        pageable.setSort(null);
        pageable.setTotalPages(totalPages);

        List<SignalContent> list = new ArrayList();
        List<SignalResult> list_1 = new ArrayList();

        //解析给定信号
        for(String s:signal){
//            List<SignalContent> list = new ArrayList();
            list.clear();
            System.out.println("正在解析的信号是："+s);
            for(RvmBigdataResult rvmBigdataResult:content){
                SignalContent signalContent = new SignalContent();
                BigInteger time = rvmBigdataResult.getTboxTime();
                JSONObject items = rvmBigdataResult.getItems();
                String value = items.getObject(s, String.class);
                signalContent.setT(time);               //封装时间
                signalContent.setV(value);              //封装信号的值
                System.out.println("解析的信号结果是："+signalContent.toString());
                list.add(signalContent);
            }
            SignalResult signalResult = new SignalResult();
            signalResult.setSignal(s);
            signalResult.setContent(list);
            System.out.println("信号解析结果："+signalResult.toString());
            list_1.add(signalResult);
        }
        Iterator iter = list_1.iterator();
        while (iter.hasNext()){
            System.out.println("list_1迭代结果："+iter.next().toString());
        }
        ResponseResult responseResult = new ResponseResult();
        responseResult.setContent(list_1);
        responseResult.setPageable(pageable);
        System.out.println("最终返回结果："+responseResult.toString());
        return responseResult;
    }

    @Test
    public void test()throws Exception{
        String signals = "VCU_VhclActlGearPos,TPMS_PressureValue_RR";
        ResponseResult result = query_2(signals);
//        System.out.println("最终返回结果："+result.toString());
    }
}
