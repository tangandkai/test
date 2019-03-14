package com.weima.hbase.result;


import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Pageable {

/**
 * pageNumber”:1, //第1页
 *  “pageSize”:10,//一页数据条数
 *  “offset":0, //数据偏移
 *  “paged”:true //分页
 *  "totalPages":57, //总页面数
 * "totalElements":568,//总数
 */

    //当前页数
    private Integer pageNumber;

    //一页的数据大小
    private Integer pageSize;

    //偏移量
    private Integer OffSet;

    //是否分页
    private Boolean paged;

    //总的分页数
    private Integer totalPages;

    //总的元素数
    private Integer totalElements;

    //排序
    private Map sort;

    public Pageable() {
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffSet() {
        return OffSet;
    }

    public void setOffSet(Integer offSet) {
        OffSet = offSet;
    }

    public Boolean getPaged() {
        return paged;
    }

    public void setPaged(Boolean paged) {
        this.paged = paged;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Map getSort() {
        return sort;
    }

    public void setSort(Map sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Pageable{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", OffSet=" + OffSet +
                ", paged=" + paged +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", sort=" + sort +
                '}';
    }
}
