package com.weima.hbase.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
public class test {

    @Value("${rvm_bigdata.signals_statistics}")
    private String signals_statistics;
    @RequestMapping("/test_1")
    public String test_1(){
        String vin1 = "dewdwdwede";
        String vin = vin1;
        int start = 424242;
        int end = 545434;
        String order  = "vin";
        String asc = "asc";
        int limit = 10;
        int offset = 20;
        return MessageFormat.format(signals_statistics,vin,start,end,order,asc,limit,offset);
//        return null;
    }
}
