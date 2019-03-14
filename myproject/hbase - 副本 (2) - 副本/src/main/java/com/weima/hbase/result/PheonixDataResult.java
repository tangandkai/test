package com.weima.hbase.result;

/**
 * 返回结果做个格式化
 */
public class PheonixDataResult {

    private boolean status;

    private String message;

    public PheonixDataResult(){}
    public PheonixDataResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
