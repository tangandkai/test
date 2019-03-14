package com.weima.entity;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 地图
 */
public class VehicleMap implements Serializable {

    private String vin;
    private BigInteger tbox_time;
    private double latitude;
    private double longitude;

    public VehicleMap() {}

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public BigInteger getTbox_time() {
        return tbox_time;
    }

    public void setTbox_time(BigInteger tbox_time) {
        this.tbox_time = tbox_time;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "VehicleMap{" +
                "vin='" + vin + '\'' +
                ", tbox_time=" + tbox_time +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
