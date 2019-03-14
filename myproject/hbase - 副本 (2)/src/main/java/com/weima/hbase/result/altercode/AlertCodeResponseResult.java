package com.weima.hbase.result.altercode;


import com.weima.hbase.result.Pageable;
import org.springframework.stereotype.Component;

@Component
public class AlertCodeResponseResult<T> {

    private Pageable pageable;
    private T content;

    public AlertCodeResponseResult() {
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AlertCodeResponseResult{" +
                "pageable=" + pageable +
                ", content=" + content +
                '}';
    }
}
