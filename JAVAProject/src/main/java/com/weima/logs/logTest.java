package com.weima.logs;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class logTest<T> {


    private static Logger logger = Logger.getLogger(logTest.class);

    public static Logger getLogger(){
        return logger;
    }
    public static void main(String[] args) throws IOException {

        String path = "C:\\software\\IDEA\\IDEAProject\\JAVAProject\\src\\main\\resource\\log4j.properties";
        FileInputStream input = new FileInputStream(new File(path));
        PropertyConfigurator.configure(input);
        logger.error("日志输出");
    }
}
