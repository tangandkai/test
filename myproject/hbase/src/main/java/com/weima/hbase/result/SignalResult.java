package com.weima.hbase.result;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SignalResult <T>{

    private String signal;
    private List<T> content;

    public SignalResult() {
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SignalResult{" +
                "signal='" + signal + '\'' +
                ", content=" + content +
                '}';
    }
}
