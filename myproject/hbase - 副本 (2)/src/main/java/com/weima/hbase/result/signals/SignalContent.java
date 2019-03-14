package com.weima.hbase.result.signals;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * 对信号进行封装
 */

@Component
public class SignalContent {

    private String v;
    private BigInteger t;

    public SignalContent() {
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public BigInteger getT() {
        return t;
    }

    public void setT(BigInteger t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "SignalContent{" +
                "v='" + v + '\'' +
                ", t=" + t +
                '}';
    }
}
