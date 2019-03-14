package com.weima.hbase.result;


import com.weima.hbase.result.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseResult<T> {

    private Pageable pageable;
    private List<T>content;

    public ResponseResult() {
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
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
