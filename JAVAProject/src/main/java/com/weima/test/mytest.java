package com.weima.test;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

public class mytest {

    public static void main(String[]args){

        String table = "girl";
        String one = "name";
        int age = 23;
        System.out.println(String.format("insert into table %s values(\"%s\",%d)",table,one,age));
        String s = MessageFormat.format("insert into table {0} values(\"{1}\",{2})",table,one,age);
        System.out.println(s);
    }

    @Test
    public void test(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
//        long s1 = System.currentTimeMillis();
//        long s1 = calendar.getTimeInMillis();
        long s1 = date.getTime();
        System.out.println("s1="+s1);
        int j=0;
        for (int i = 0; i < 1000000; i++) {j++;}
//        long s2 = calendar.getTimeInMillis();
//        long s2 = System.currentTimeMillis();
        long s2 = date.getTime();
        System.out.println("s2="+s2+"\n"+"s2-s1="+(s2-s1));
    }

    @Test
    public void test_1(){
        String xx = "ci";
        String cc = MessageFormat.format("{0}",xx);
        System.out.println(String.format("%s.x",xx));
        System.out.println(cc);
    }

    @Test
    public void test_2(){
        BigInteger bigInteger = new BigInteger("1544685612000");
        System.out.println(bigInteger);
    }
}
