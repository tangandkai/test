package com.weima.hbase.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class TimeChange {

    public Map<String,Object> getTime(Integer day){
        Map<String,Object> list = new HashMap<>();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat df1=new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        //pt对应分区时间
        String pt = df1.format(calendar.getTime());
        list.put("pt",pt);
        //获取day天前的时间，并转成格式化 yyyy-MM-dd hh:mm:ss
        calendar.add(Calendar.DATE,-day);
        long timeStamp = calendar.getTimeInMillis();
        list.put("timeStamp",timeStamp);
        String lastdate = df.format(calendar.getTime());
        list.put("lastdate",lastdate);
        String lastdate_pt = df2.format(calendar.getTime());
        list.put("lastdate_pt",lastdate_pt);
        return list;
    }
}
