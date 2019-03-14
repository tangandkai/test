package com.weima.Time;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class getCurrentTime {

    @Test
    public void getTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = calendar.getTime();
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.DATE,-1);
        System.out.println(calendar.getTimeInMillis());

        System.out.println("time="+time);
        BigInteger timeStamp = new BigInteger("123213132133");
        String sortby = "tbox";
        String order = "asc";
        int pagesize =10;
        int offset =0;
        String sql = String.format(
                "select \"vin\",\"platform\",\"latest_report_time\",\"latitude\",\"longitude\" from RVM_LATEST_UPLOAD_LOCATION where \"%s\"<=%d order by \"%s\" %s limit %d offset %d","latest_report_time",timeStamp,sortby,order,pagesize,offset);

        System.out.println(sql);
    }
}
