package com.weima.mapper;

import com.weima.entity.VehicleMap;

import java.util.List;

public interface mapMapper {

    //查询所有的数据
    public List<VehicleMap> findAll();

    public void insert(VehicleMap vehicleMap);
}
