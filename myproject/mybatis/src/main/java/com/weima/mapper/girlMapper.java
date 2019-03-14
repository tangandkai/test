package com.weima.mapper;

import com.weima.entity.Girl;

import java.util.List;

public interface girlMapper {

    //查询所有的数据
    public List<Girl> findAll();

    public void insert(Girl girl);

}
