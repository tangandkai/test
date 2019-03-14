package com.weima;

import com.weima.entity.VehicleMap;
import com.weima.file.FileObject;
import com.weima.service.girlMapperImpl;
import com.weima.entity.Girl;
import com.weima.service.mapMapperImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class controller {

    public static void main(String[] args)throws Exception{
//        insert();
        girlquery();
//        mapinsert();
//        insert();
//        mapquery();
    }

    public static void girlinsert(){
        girlMapperImpl girlMapper = new girlMapperImpl("bdap");
        Girl girl = new Girl();
        girl.setId(1);
        girl.setName("mack");
        girl.setAddress("安徽省合肥市高新区声谷");
        girl.setAge(21);
        girl.setCupsize("C");
        girl.setEmail("4642342@qq.com");
        girlMapper.insert(girl);
    }

    public static void girlquery(){
        girlMapperImpl girlMapper = new girlMapperImpl("bdap");
        List<Girl> result = girlMapper.findAll();
        for (Girl girl:result){
            System.out.println(girl.toString());
        }
    }


    public  static void mapinsert(){
        mapMapperImpl mapper = new mapMapperImpl("bdap");
        VehicleMap vehicleMap = new VehicleMap();
        vehicleMap.setVin("LL2274084JW100048");
        vehicleMap.setTbox_time(new BigInteger("1543487139000"));
        vehicleMap.setLatitude(31.17545);
        vehicleMap.setLongitude(121.302809);
        mapper.insert(vehicleMap);
    }

    public static void mapquery(){
        mapMapperImpl mapper = new mapMapperImpl("bdap");
        List<VehicleMap> result = mapper.findAll();
        for(VehicleMap vehicleMap :result){
            System.out.println(vehicleMap.toString());
        }
    }

    public static void insert() throws IOException, InterruptedException {
        double i = 0.001;
        double k = 0.002;
        int j = 1;
        mapMapperImpl mapper = new mapMapperImpl("bdap");
        VehicleMap vehicleMap = new VehicleMap();
        String path = "C:\\query-hive-8564.csv";
        String line = null;
        FileObject fileObject = new FileObject();
        BufferedReader br = fileObject.readCsv(path);
        while ((line=br.readLine())!=null){
            i=i+0.001;
            k=k+0.033;
            j=j+1;
            String[] list = line.split(",");
            if (j%2==0){
                vehicleMap.setVin(list[0]+"2");
                vehicleMap.setLatitude(Double.parseDouble(list[2])+k);
                vehicleMap.setLongitude(Double.parseDouble(list[3])+k);
            }
            else{
                vehicleMap.setVin(list[0]);
                vehicleMap.setLatitude(Double.parseDouble(list[2])+i);
                vehicleMap.setLongitude(Double.parseDouble(list[3])+i);
            }
//            vehicleMap.setVin(list[0]);
            vehicleMap.setTbox_time(new BigInteger(list[1]));
//            vehicleMap.setLatitude(Double.parseDouble(list[2])+i);
//            vehicleMap.setLongitude(Double.parseDouble(list[3])+i);
            mapper.insert(vehicleMap);
            Thread.sleep(900);
        }
        br.close();
    }
}
