package com.weima.mysql.utils;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class GetTime {

    public static Map<String,Object> getTime(){

        Map<String,Object> list = new HashMap<>();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat df_1=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        long timeStamp = System.currentTimeMillis();
        String currentDate = df.format(timeStamp);
        String startDate = df_1.format(timeStamp);
        System.out.println(startDate+"\t"+currentDate);
        Timestamp startTimeStamp = Timestamp.valueOf(startDate);
        Timestamp currentTimestamp = Timestamp.valueOf(currentDate);
        System.out.println("currentTimestamp="+currentTimestamp);
        System.out.println("startTimeStamp="+startTimeStamp);
        list.put("currentTimestamp",currentTimestamp);
        list.put("startTimeStamp",startTimeStamp);
        list.put("currentDate",currentDate);
        list.put("startDate",startDate);
        return list;
    }

//    public static void main(String[] args) {
//        getTime();
//    }
}
