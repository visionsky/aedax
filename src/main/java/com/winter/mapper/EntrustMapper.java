package com.winter.mapper;

import com.winter.model.Entrust;

import java.util.List;

public interface EntrustMapper {
    int deleteByPrimaryKey(String entrustid);

    int insert(Entrust record);
    List<Entrust> select(Entrust record);
    int insertSelective(Entrust record);

    Entrust selectByPrimaryKey(String entrustid);


    int updateByPrimaryKeySelective(Entrust record);

    int updateByPrimaryKey(Entrust record);
}