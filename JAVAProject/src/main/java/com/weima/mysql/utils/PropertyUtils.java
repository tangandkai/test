package com.weima.mysql.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    private static PropertyUtils property = null;

    private PropertyUtils(){}

    public static PropertyUtils getInstance(){
        if(null==property){
            return  new PropertyUtils();
        }
        return property;
    }

    public Properties getProperties(String path) {
        Properties pro = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream(path);
            pro.load(in);
            return  pro;
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (in==null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

//    public static void main(String[] orgs) throws IOException {
//        PropertyUtils pp = PropertyUtils.getInstance();
//        Properties result = pp.getProperties("C:\\software\\IDEA\\IDEAProject\\JAVAProject\\src\\main\\resource\\jdbc.properties");
//        System.out.println(result.getProperty("driver"));
//    }
}
