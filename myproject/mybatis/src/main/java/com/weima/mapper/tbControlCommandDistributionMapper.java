package com.weima.mapper;

import com.weima.entity.tbControlCommandDistribution;

import java.sql.Timestamp;
import java.util.List;

public interface tbControlCommandDistributionMapper {

    public List<tbControlCommandDistribution> findDistribute(Timestamp timestamp);
}
