package com.weima.entity;

import java.io.Serializable;

public class tbControlCommandDistribution implements Serializable {

    //设备名称
    private String device;
    //指令操作内容
    private String command;
    //指令成功数目
    private Integer sucess_num;
    //指令成功平均耗时
    private Double avg_sucess_time;
    //指令失败数目
    private Integer failed_num;
    //指令失败平均耗时
    private Double avg_failed_time;
    //无效指令失败数目
    private Integer failed_useless_num;
    //无效指令失败的平均耗时
    private Double avg_failed_useless_time;


    public tbControlCommandDistribution() {}

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Integer getSucess_num() {
        return sucess_num;
    }

    public void setSucess_num(Integer sucess_num) {
        this.sucess_num = sucess_num;
    }

    public Double getAvg_sucess_time() {
        return avg_sucess_time;
    }

    public void setAvg_sucess_time(Double avg_sucess_time) {
        this.avg_sucess_time = avg_sucess_time;
    }

    public Integer getFailed_num() {
        return failed_num;
    }

    public void setFailed_num(Integer failed_num) {
        this.failed_num = failed_num;
    }

    public Double getAvg_failed_time() {
        return avg_failed_time;
    }

    public void setAvg_failed_time(Double avg_failed_time) {
        this.avg_failed_time = avg_failed_time;
    }

    public Integer getFailed_useless_num() {
        return failed_useless_num;
    }

    public void setFailed_useless_num(Integer failed_useless_num) {
        this.failed_useless_num = failed_useless_num;
    }

    public Double getAvg_failed_useless_time() {
        return avg_failed_useless_time;
    }

    public void setAvg_failed_useless_time(Double avg_failed_useless_time) {
        this.avg_failed_useless_time = avg_failed_useless_time;
    }

    @Override
    public String toString() {
        return "tbControlCommandDistributionMapper{" +
                "device='" + device + '\'' +
                ", command='" + command + '\'' +
                ", sucess_num=" + sucess_num +
                ", avg_sucess_time=" + avg_sucess_time +
                ", failed_num=" + failed_num +
                ", avg_failed_time=" + avg_failed_time +
                ", failed_useless_num=" + failed_useless_num +
                ", avg_failed_useless_time=" + avg_failed_useless_time +
                '}';
    }
}
