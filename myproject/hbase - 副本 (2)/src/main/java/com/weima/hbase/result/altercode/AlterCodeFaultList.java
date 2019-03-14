package com.weima.hbase.result.altercode;

import org.springframework.stereotype.Component;


@Component
public class AlterCodeFaultList {

    private String AlterCode;
    private Long num;

    public AlterCodeFaultList() {
    }

    public AlterCodeFaultList(String alterCode, Long num) {
        AlterCode = alterCode;
        this.num = num;
    }

    public String getAlterCode() {
        return AlterCode;
    }

    public void setAlterCode(String alterCode) {
        AlterCode = alterCode;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "AlterCodeFaultList{" +
                "AlterCode='" + AlterCode + '\'' +
                ", num=" + num +
                '}';
    }
}
