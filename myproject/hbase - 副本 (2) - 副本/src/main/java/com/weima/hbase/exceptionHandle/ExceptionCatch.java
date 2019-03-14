package com.weima.hbase.exceptionHandle;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionCatch {

    private static final Logger logger = Logger.getLogger(ExceptionCatch.class);
    @ExceptionHandler(value = Exception.class)
    public Object loggerHandle(Exception e){
        logger.error(e.toString());
        return e;
    }
}
