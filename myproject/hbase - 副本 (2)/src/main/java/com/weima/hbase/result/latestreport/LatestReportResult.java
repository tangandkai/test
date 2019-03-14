package com.weima.hbase.result.latestreport;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 封装信号最后上报结果
 */
@Component
public class LatestReportResult {

    private String vin;
    private BigInteger latestReportTime;
    private String platform;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public LatestReportResult() {
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public BigInteger getLatestReportTime() {
        return latestReportTime;
    }

    public void setLatestReportTime(BigInteger latestReportTime) {
        this.latestReportTime = latestReportTime;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "LatestReportResult{" +
                "vin='" + vin + '\'' +
                ", latestReportTime=" + latestReportTime +
                ", platform='" + platform + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
