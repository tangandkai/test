package com.weima.hbase.result.altercode;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlterCodeTotalVehicle<T> {

    private List<T> faultList;
    private Integer totalVehicle;
    private Integer totalFaultVehicle;

    public AlterCodeTotalVehicle() {
    }

    public List<T> getFaultList() {
        return faultList;
    }

    public void setFaultList(List<T> faultList) {
        this.faultList = faultList;
    }

    public Integer getTotalVehicle() {
        return totalVehicle;
    }

    public void setTotalVehicle(Integer totalVehicle) {
        this.totalVehicle = totalVehicle;
    }

    public Integer getTotalFaultVehicle() {
        return totalFaultVehicle;
    }

    public void setTotalFaultVehicle(Integer totalFaultVehicle) {
        this.totalFaultVehicle = totalFaultVehicle;
    }

    @Override
    public String toString() {
        return "AlterCodeTotalVehicle{" +
                "faultList=" + faultList +
                ", totalVehicle=" + totalVehicle +
                ", totalFaultVehicle=" + totalFaultVehicle +
                '}';
    }
}
