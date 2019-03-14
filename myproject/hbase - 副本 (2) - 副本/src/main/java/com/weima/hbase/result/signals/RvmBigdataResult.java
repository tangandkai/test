package com.weima.hbase.result.signals;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class RvmBigdataResult {

    private String iccid;
    private String vin;
    private Boolean reissue;
    private String tboxVersion;
    private BigInteger tboxTime;
    private String version;
    private BigInteger parseTime;
    private JSONObject items;
    private JSONObject mappingItems;

    public RvmBigdataResult() {
    }

    public RvmBigdataResult(String iccid, String vin, Boolean reissue, String tboxVersion, BigInteger tboxTime, String version, BigInteger parseTime, JSONObject items, JSONObject mappingItems) {
        this.iccid = iccid;
        this.vin = vin;
        this.reissue = reissue;
        this.tboxVersion = tboxVersion;
        this.tboxTime = tboxTime;
        this.version = version;
        this.parseTime = parseTime;
        this.items = items;
        this.mappingItems = mappingItems;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Boolean getReissue() {
        return reissue;
    }

    public void setReissue(Boolean reissue) {
        this.reissue = reissue;
    }

    public String getTboxVersion() {
        return tboxVersion;
    }

    public void setTboxVersion(String tboxVersion) {
        this.tboxVersion = tboxVersion;
    }

    public BigInteger getTboxTime() {
        return tboxTime;
    }

    public void setTboxTime(BigInteger tboxTime) {
        this.tboxTime = tboxTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigInteger getParseTime() {
        return parseTime;
    }

    public void setParseTime(BigInteger parseTime) {
        this.parseTime = parseTime;
    }

    public JSONObject getItems() {
        return items;
    }

    public void setItems(JSONObject items) {
        this.items = items;
    }

    public JSONObject getMappingItems() {
        return mappingItems;
    }

    public void setMappingItems(JSONObject mappingItems) {
        this.mappingItems = mappingItems;
    }

    @Override
    public String toString() {
        return "RvmBigdataResult{" +
                "iccid='" + iccid + '\'' +
                ", vin='" + vin + '\'' +
                ", reissue=" + reissue +
                ", tboxVersion='" + tboxVersion + '\'' +
                ", tboxTime=" + tboxTime +
                ", version=" + version +
                ", parseTime=" + parseTime +
                ", items='" + items + '\'' +
                ", mappingItems='" + mappingItems + '\'' +
                '}';
    }
}
