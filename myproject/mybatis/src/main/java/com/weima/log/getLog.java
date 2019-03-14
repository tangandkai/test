package com.weima.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class getLog<T> {

    public static Logger logger() {
        try {
//            FileInputStream input = new FileInputStream(new File("log4j.properties"));
//            PropertyConfigurator.configure(input);
            Logger logger = Logger.getLogger(getLog.class);
            return logger;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
